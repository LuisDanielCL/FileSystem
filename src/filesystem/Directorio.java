package filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kurayami
 */
public class Directorio extends ArchivoMaestro {
    List<Archivo> archivos = new ArrayList<>();
    List<Directorio> directorios = new ArrayList<>();
    Directorio directorioAnterior;
    String ruta;
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
        for (int i = 0; i < directorios.size(); i++) {
            if(directorios.get(i).nombre.equals(nuevaDir)){
                return directorios.get(i);
            }
        }
        System.out.print("No se encontro el directorio especificado.");
        return this;
    }

    public boolean agregarDirectorio(String nombreDirectorio){
        System.out.print(nombre+":");
        for (int i = 0; i < directorios.size(); i++) {
            if(directorios.get(i).nombre.equals(nombreDirectorio)){
                System.out.print("El directorio ya existe.");
                return false;
            }
        }
        Directorio nuevoDir = new Directorio(nombreDirectorio,this);
        directorios.add(nuevoDir);
        
        return true;
    }
    
    public void printDir(){
        for (int i = 0; i < directorios.size(); i++) {
            System.out.print(directorios.get(i).nombre + "\n");   
        }
        for (int i = 0; i < archivos.size(); i++) {
            System.out.print(archivos.get(i).nombre +"."+tipo+ "\n");         
        }
    }
    

    public boolean agregarArchivo(String datos, String nombreArchivo, String tipo){
        for (int i = 0; i < archivos.size(); i++) {
            if(archivos.get(i).nombre.equals(nombreArchivo)){
                System.out.print("El archivo ya existe.");
                return false;
            }
        }
        Archivo nuevoArchivo = new Archivo(datos, nombreArchivo, tipo);
        archivos.add(nuevoArchivo);
        return true;
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
