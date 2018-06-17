package filesystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 *
 * @author kurayami
 */
public class Archivo extends ArchivoMaestro {
    //int id;
    ArrayList ubicacion = new ArrayList();
    //int tamano;
    String fechaCreacion;
    String ultimaModificacion;
    String datos; 
    
    public Archivo(String pDatos,String pNombre, String pTipo, ArrayList pUbicacion){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fechaCreacion = now.format(formatter);
        ultimaModificacion = now.format(formatter);
        //fechaCreacion = now.getDayOfMonth()+ "-" + now.getMonth() + "-" + now.getYear() + " " + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond();
        datos = pDatos;
        nombre = pNombre;
        tipo = pTipo;
        ubicacion = (ArrayList) pUbicacion.clone();
               
    }

    public ArrayList getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(ArrayList ubicacion) {
        this.ubicacion.add(ubicacion);
    }
    
    /*public int getTamano() {
        return this.tamano;
    }
    
    public void setTamano(int tamano){
        this.tamano = tamano;
    }
    */
    public String getDatos() {
        return this.datos;
    }
    
    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    public String verPropiedades(){
        String propiedadesA;
        propiedadesA = "Nombre: " + nombre + "\n" + "Extension: " + tipo + "\n" +
                "Fecha de creacion: " + fechaCreacion + "\n" + "Ultima modificacion: " + 
                ultimaModificacion + "\n" + "Tamaño: " + datos.length() + "\n";
        return propiedadesA;
    }    
}
