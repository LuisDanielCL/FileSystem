package filesystem;

import java.io.*;
import java.util.LinkedList;
/**
 *
 * @author kurayami
 */
public class DiscoVirtual {
    private String nombre;
    private int tamSector;
    private int numSectores;
    private int tamDiscoV;    
    LinkedList vacios = new LinkedList();
    LinkedList ocupados = new LinkedList();
    
    public DiscoVirtual(String pNombre, int pTamSector,int pNumSectores){
        nombre = pNombre;
        tamSector = pTamSector;
        numSectores = pNumSectores ;
        for (int i = 0; i < this.getNumSectores(); i++){
            vacios.add(i);
        }
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getTamSector() {
        return this.tamSector;
    }
    
    public void setTamSector(int tamSector){
        this.tamSector = tamSector;
    }
    
    public int getNumSectores() {
        return this.numSectores;
    }
    
    public void setNumSectores(int numSectores){
        this.numSectores = numSectores;
    }
    
    public void setTamDiscoV(){
        this.tamDiscoV = tamSector * numSectores;
    }
    
    public int getTamDiscoV(){
        return this.tamDiscoV;
    }      
    
    public void crearRespaldo(){
        File discoRespaldo = new File(this.getNombre()+".txt");
        if (!discoRespaldo.exists()){
            try{
                discoRespaldo.createNewFile();
                System.out.println(discoRespaldo.getName()+ " ha sido creado");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        try{
            PrintWriter escribir = new PrintWriter(discoRespaldo);
            for(int i = 0; i < this.tamDiscoV; i++){
                escribir.print("0");
            }
            System.out.println(discoRespaldo.getName()+ " ha sido modificado");
            escribir.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void llenarSectores(int tamano, LinkedList sectores){
        
    }
    public void vaciarSectores(){
        //proximamente
    }
}