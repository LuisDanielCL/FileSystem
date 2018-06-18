
package filesystem;

import java.util.LinkedList;
import java.util.Scanner;

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
        volumen = new Directorio(nombreDisco);
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

    void crearDirectorio(String nombreDirectorio, DiscoVirtual disco) {
        dirActual.agregarDirectorio(nombreDirectorio, disco);
    }

    void mostrarEstructuraActual() {
        volumen.printDir("");
    }

    void cambiarDirectorio(String nombreDirectorio) {
        dirActual = dirActual.moverseA(nombreDirectorio);
    }

    String getRuta() {
        return dirActual.getRuta();
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


    void eliminarArchivo(String nombre, DiscoVirtual disco) {
        dirActual.elimiarArchivo(nombre, disco);
    }
    
    void propiedadesArchivo(String nombreArchivo, DiscoVirtual disco){
        dirActual.propiedadesArchivo(nombreArchivo, disco);

    }
    
    void cambiarContenidoArchivo(String nombreArchivo, DiscoVirtual disco, String nuevoContenido){
        dirActual.cambiarContenidoArchivo(nombreArchivo, disco, nuevoContenido);
    }

    void eliminarDirectorio(String nombre, DiscoVirtual discoVirtual) {
        dirActual.elimiarDirectorio(nombre, discoVirtual);
    }
    
    void contenidoArchivo(String nombreArchivo, DiscoVirtual disco){
        dirActual.contenidoArchivo(nombreArchivo, disco);


    }

    void moverDirectorio(String nombreArchivo, String nuevaRuta, String nuevoNombre, DiscoVirtual discoVirtual) {
        dirActual.moverDirectorio(nombreArchivo, nuevaRuta, nuevoNombre, volumen, discoVirtual);

    }
    


    void moverArchivo(String nombreArchivo, String nuevaRuta, String nuevoNombre, DiscoVirtual discoVirtual) {
                dirActual.moverArchivo(nombreArchivo, nuevaRuta, nuevoNombre, 
                volumen, discoVirtual);
    }

    void buscarDocumento(String nombre) {
        volumen.buscarDocumentos(nombre);
    }
}
