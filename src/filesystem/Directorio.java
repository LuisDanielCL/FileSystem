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

    public void elimiarArchivo(String nombreArch) {
        for(int i=0;i< archivos.size(); i++){
            if(archivos.get(i).nombre.equals(nombreArch)){
                Archivo archivoEliminar = archivos.get(i);
                
            }
        }
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
    /*
    public boolean agregarArchivo(Archivo a){
        for(int i = 0; i < contenido.size(); i++) {
            Object o = contenido.get(i);
            if ( o instanceof Archivo){
                Archivo archivoA = (Archivo) o;
                if (archivoA.nombre.equals(a.nombre) && archivoA.tipo.equals(a.tipo)){
                    System.out.println("Ya existe ese archivo");
                    return false;
                }
                System.out.println(archivoA.nombre);
            }
        }
        this.contenido.add(a);
        return true;
    }
    */
    /*
    public boolean agregarDirectorio(Directorio a){
        for(int i = 0; i < contenido.size(); i++) {
            Object o = contenido.get(i);
            if ( o instanceof Directorio){
                Directorio DirectorioA = (Directorio) o;
                if (DirectorioA.nombre.equals(a.nombre)){
                    System.out.println("Ya existe ese directorio");
                    return false;
                }
                System.out.println(DirectorioA.nombre);
            }
        }
        this.contenido.add(a);
        return true;
    }
    */
    /*
    public void BorrarDirectorioCompleto(){
        if (!contenido.isEmpty()){
            for(int i = 0; i < contenido.size(); i++){
                Object o = contenido.get(i);
                    if (o instanceof Archivo){
                        this.agregarArchivo((Archivo) o);
                    }else{
                        Directorio d = (Directorio) o;
                        d.BorrarDirectorioCompleto();
                    }
                    
                    
            }
        }
        
    }
    */
    /*
    public void removerDirectorio(String directorioEliminar){
        for(int i = 0; i < contenido.size(); i++) {
            Object o = contenido.get(i);
            if ( o instanceof Directorio){
               Directorio directorioA = (Directorio) o;
                if (directorioA.nombre.equals(directorioEliminar)){
                    if (directorioA.contenido.isEmpty()){
                        BorrarDirectorioCompleto();
                    }
            }
            if ( o instanceof Archivo){
                contenido.remove(o);
            }
            if ( o instanceof Directorio){
                contenido.remove(removerDirectorio);
            }
            }
        }
    }
    */
    /*
    public void verDirectorio(){
        for(int i = 0; i < contenido.size(); i++) {
            Object o = contenido.get(i);
            if ( o instanceof Archivo){
                Archivo archivoA = (Archivo) o;
                System.out.println(archivoA.nombre);
                }
            }
    }
    */
    /*
    public void removerArchivo(String archivoEliminar){
        for(int i = 0; i < contenido.size(); i++) {
            Object o = contenido.get(i);
            if ( o instanceof Archivo){
                Archivo archivoA = (Archivo) o;
                if (archivoA.nombre.equals(archivoEliminar)){
                    contenido.remove(o);
                }
            }
        }
    }
    */






}
