
package filesystem;

import java.util.LinkedList;

/**
 *
 * @author kurayami
 */
public class SystemaDeArchivo {
    LinkedList SystemaDeArchivos = new LinkedList();
    String current;
    String root;
    String rutaA;
    Directorio volumen;
    Directorio dirActual;
    public SystemaDeArchivo(String nombreDisco){
        this.current = nombreDisco;
        this.root = nombreDisco;
        this.rutaA = nombreDisco;
        Directorio volumen = new Directorio(nombreDisco);
        dirActual = volumen;
    }
    
    public LinkedList getSystemaDeArchivos(){
        return SystemaDeArchivos;
    }
    public void setSystemaDeArchivos( ArchivoMaestro archivomaestro){
        this.SystemaDeArchivos.add(archivomaestro);
    }
    public String getCurrent(){
        return current;
    }
    public void setCurrent(String actual){
        this.current = actual;
    }
    public String getRoot(){
        return root;
    }
    public void setRoot(String root){
        this.root = root;
    }
    
    public String getRutaA(){
        return rutaA;
    }
    
    public void setRutaA(String ruta){
        this.rutaA = rutaA + "\\" + ruta;
    }

    void crearDirectorio(String nombreDirectorio) {
        dirActual.agregarDirectorio(nombreDirectorio);
    }

    void mostrarEstructuraActual() {
        dirActual.printDir("");
    }

    void cambiarDirectorio(String nombreDirectorio) {
        dirActual = dirActual.moverseA(nombreDirectorio);
    }

    String getRuta() {
        
        return dirActual.ruta;
    }

    void volverAtras() {
        dirActual = dirActual.volverAtras();
    }

    void listarDirectorioActual() {
        dirActual.listarDirectorio();
    }

    void crearArchivo(String texto, String nombreArchivo, String extension, DiscoVirtual discoVirtual) {
        dirActual.agregarArchivo(texto, nombreArchivo, extension, discoVirtual);
    }
    
    void propiedadesArchivo(String nombreArchivo, DiscoVirtual disco){
        dirActual.propiedadesArchivo(nombreArchivo, disco);
    }
}
