package filesystem;

import java.util.LinkedList;


/**
 *
 * @author kurayami
 */
public class Archivo extends ArchivoMaestro {
    //int id;
    LinkedList ubicacion = new LinkedList();
    int tamano;
    //fecha, hora creacion
    //fecha, hora ultima modificación
    String datos;    
    
    /*
    public int getId() {
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    */
    public LinkedList getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(int ubicacion) {
        this.ubicacion.add(ubicacion);
    }
    
    public int getTamano() {
        return this.tamano;
    }
    
    public void setTamano(int tamano){
        this.tamano = tamano;
    }
    
    public String getDatos() {
        return this.datos;
    }
    
    public void setDatos(String datos) {
        this.datos = datos;
    }
}
