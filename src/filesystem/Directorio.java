package filesystem;

import java.util.LinkedList;

/**
 *
 * @author kurayami
 */
public class Directorio extends ArchivoMaestro {
    LinkedList contenido = new LinkedList();
    
    public Directorio(String nombre){
        this.nombre = nombre;
        this.contenido = new LinkedList();
    }
    
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
            /*if ( o instanceof Archivo){
                contenido.remove(o);
            }
            if ( o instanceof Directorio){
                contenido.remove(removerDirectorio);
            }*/
            }
        }
    }
    
    
    public void verDirectorio(){
        for(int i = 0; i < contenido.size(); i++) {
            Object o = contenido.get(i);
            if ( o instanceof Archivo){
                Archivo archivoA = (Archivo) o;
                System.out.println(archivoA.nombre);
                }
            }
    }
    
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
}
