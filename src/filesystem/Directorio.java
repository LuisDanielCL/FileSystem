package filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kurayami
 */
public class Directorio extends ArchivoMaestro {
    List<Archivo> archivos = new ArrayList<>();
    List<Directorio> directorios = new ArrayList<>();
    Directorio directorioAnterior;
    String ruta;
    Scanner entrada = new Scanner(System.in);
    public Directorio(String nombre){
        this.nombre = nombre;
        ruta = nombre;
        directorioAnterior = null;
    }

    public Directorio(String nombre, Directorio dirAnterior){
        this.nombre = nombre;
        ruta =dirAnterior.ruta+"/"+nombre;
        directorioAnterior = dirAnterior;
    }
    
    public Directorio moverseA(String nuevaDir){
        String[] divDir = nuevaDir.split("/", 2);
        
        for (int i = 0; i < directorios.size(); i++) {
            if(directorios.get(i).nombre.equals(divDir[0])){
                if(divDir.length > 1){
                    return directorios.get(i).moverseA(divDir[1]);
                }
                return directorios.get(i);
            }
        }
        System.out.println("No se encontro el directorio especificado.");
        return this;
    }
    public Directorio volverAtras(){
        if(directorioAnterior == null){
            System.out.println("No se puede volver, ya esta en la raiz.");
            return this;
        }
        return directorioAnterior;
    }

    public boolean agregarDirectorio(String nombreDirectorio){
        for (int i = 0; i < directorios.size(); i++) {
            if(directorios.get(i).nombre.equals(nombreDirectorio)){
                System.out.print("El directorio ya existe, desea remplazarlo(S/N):");
                String opcion = entrada.nextLine();
                switch (opcion.toUpperCase()){
                case "S":
                    System.out.println("Se remplaza");
                    //Eliminar()
                    //eliminar el return y dejar brake
                    return false;
                    //break;
                    
                case "N":
                    System.out.println("Se mantiene");
                    return false;
                default:
                    System.out.println("Comando invalido");
                    return false;
                }
                
            }
        }
        Directorio nuevoDir = new Directorio(nombreDirectorio,this);
        directorios.add(nuevoDir);
        
        return true;
    }
    
    public void printDir(String profundidad){
        for (int i = 0; i < directorios.size(); i++) {
            System.out.print(profundidad + directorios.get(i).nombre + "\n");
            directorios.get(i).printDir("-"+profundidad);
        }
        for (int i = 0; i < archivos.size(); i++) {
            System.out.print(profundidad + archivos.get(i).nombre +"."+archivos.get(i).tipo+ "\n");         
        }
    }
    
    public void listarDirectorio(){
        for (int i = 0; i < directorios.size(); i++) {
            System.out.print("DIR---"+directorios.get(i).nombre + "\n");   
        }
        for (int i = 0; i < archivos.size(); i++) {
            System.out.print("FILE---"+archivos.get(i).nombre +"."+archivos.get(i).tipo+ "\n");         
        }
    }
    
    

    public boolean agregarArchivo(String datos, String nombreArchivo, String tipo,
            DiscoVirtual disco){
        for (int i = 0; i < archivos.size(); i++) {
            if(archivos.get(i).nombre.equals(nombreArchivo)){
                System.out.print("El archivo ya existe.");
                return false;
            }
        }
        int sectoresRequeridos = (int) Math.ceil(datos.length() / disco.getTamSector());
        if (sectoresRequeridos >= disco.sectoresDisponibles()){
            System.out.println("No hay espacio en disco para crear ese archivo");
            return false;
        }
        ArrayList ubicacion = disco.llenarSectores(datos.length());
        Archivo nuevoArchivo = new Archivo(datos, nombreArchivo, tipo,ubicacion);
        archivos.add(nuevoArchivo);
        disco.crearRespaldo();
        return true;
    }

    public void elimiarArchivo(String nombreArch, DiscoVirtual disco) {
        for(int i=0;i< archivos.size(); i++){
            if(archivos.get(i).nombre.equals(nombreArch)){
                elimiarArchivoFix(i,disco);
                return;
            }
        }
    }
    
    private void elimiarArchivoFix(int pos, DiscoVirtual disco) {
        disco.vaciarSectores(archivos.get(pos).ubicacion);
        archivos.remove(pos);
        disco.crearRespaldo();
    }   
    
    void elimiarDirectorio(String nombreDir, DiscoVirtual disco) {
        for(int i=0;i< directorios.size(); i++){
            if(directorios.get(i).nombre.equals(nombreDir)){
                eliminarRecursivo(i,disco);
                directorios.remove(i);
                return;
            }
        }
    }
    
    private void eliminarRecursivo(int pos, DiscoVirtual disco){
        for(int i = 0; i<directorios.get(pos).directorios.size(); i++){
            directorios.get(pos).eliminarRecursivo(i,disco);
        }
        directorios.get(pos).directorios.clear();
        for (Archivo archivo : directorios.get(pos).archivos) {
            disco.vaciarSectores(archivo.ubicacion);
            disco.crearRespaldo();
        }
        directorios.get(pos).archivos.clear();
    }
    
    public boolean propiedadesArchivo(String nombreArchivo, DiscoVirtual disco){
        for (int i = 0; i < archivos.size(); i++) {
            if(archivos.get(i).nombre.equals(nombreArchivo)){
                System.out.println("El archivo fue encontrado.");
                archivos.get(i).verPropiedades();
                return true;
            }
        }
        System.out.print("El archivo no fue encontrado.");
        return false;
    }
    

    public boolean contenidoArchivo(String nombreArchivo, DiscoVirtual disco){
        for (int i = 0; i < archivos.size(); i++) {
            if(archivos.get(i).nombre.equals(nombreArchivo)){
                System.out.println("El archivo fue encontrado.");
                archivos.get(i).getDatos();
                return true;
            }
        }
        System.out.print("El archivo no fue encontrado.");
        return false;
    }

}
