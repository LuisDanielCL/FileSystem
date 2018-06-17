package filesystem;

import java.util.LinkedList;

import java.util.Date;
/**
 *
 * @author kurayami
 */
public class Archivo extends ArchivoMaestro {
    //int id;
    LinkedList ubicacion = new LinkedList();
    int tamano;
    String fechaCreacion;
    String ultimaModificacion;
    String datos; 
    String nombre;
    
    public Archivo(String pDatos,String pNombre, String pTipo){
        datos = pDatos;
        nombre = pNombre;
        tipo = pTipo;
        
    }

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
