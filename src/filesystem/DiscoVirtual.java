package filesystem;

import java.io.*;
/**
 *
 * @author kurayami
 */
public class DiscoVirtual {
    private String nombre;
    private int tamSector;
    private int numSectores;
    private int tamDiscoV;
    
    public DiscoVirtual(int pSectores, int pTamSector,int pNumSectores){
        tamSector = pTamSector;
        tamSector = pTamSector;
        numSectores = pNumSectores ;
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
    
    public void modificarRespaldo(){
        //proximamente
    }
}