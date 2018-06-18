package filesystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
    List<Integer> sector;
    public DiscoVirtual(String pNombre, int pTamSector,int pNumSectores){
        nombre = pNombre;
        tamSector = pTamSector;
        numSectores = pNumSectores ;
        sector = new ArrayList<Integer>(Collections.nCopies(numSectores, 0));

        
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
            for(int i = 0; i < sector.size(); i++){
                int camposOcupados = sector.get(i);
                for(int j=0; j< tamSector; j++){
                    
                    if(j<camposOcupados){
                        escribir.print("1");
                    }else{
                        escribir.print("0");
                    }
                }
                
            }
            System.out.println(discoRespaldo.getName()+ " ha sido modificado");
            escribir.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public int sectoresDisponibles(){
        int cantidad = 0;
        for(int i = 0; i < numSectores ; i++ ){
            if (sector.get(i) == 0){
                cantidad = cantidad + 1;
            }
        }
        return cantidad;
    }
    public ArrayList llenarSectores(int tamano){
        ArrayList sectoresArchivo = new ArrayList();
        for(int i = 0; i < sector.size() ; i++ ){
            if (sector.get(i) == 0){
                sectoresArchivo.add(i);
                if(tamano <= tamSector){
                    sector.set(i,tamano);
                    return sectoresArchivo;
                }
                sector.set(i,tamSector);
                tamano -= tamSector;
            }
        }
        return sectoresArchivo;
    }
    
    public ArrayList masSectores(ArrayList sectores, int nuevoTama){
        ArrayList sectoresArchivo = new ArrayList();
        int dif = (sectores.size() * tamSector) - nuevoTama;
        sector.set((int) sectores.get(sectores.size() -1 ), tamSector);
        llenarSectores(dif);
        //ArrayList ubicacion = disco.llenarSectores(datos.length());
        sectoresArchivo.addAll(sectores);
        sectoresArchivo.addAll(llenarSectores(dif));
        return sectoresArchivo;
    }
    
    public ArrayList menosSectores(ArrayList sectores, int nuevoTama){
        ArrayList sectoresArchivo = new ArrayList();
        for(int i = 0; i < sectores.size() ; i++ ){
            if(nuevoTama <= 0){
                sector.set((int) sectores.get(i), 0);
            }else{
                if(tamSector <= nuevoTama){
                    sector.set((int) sectores.get(i), tamSector);
                    sectoresArchivo.add(sectores.get(i));
                    nuevoTama -= tamSector;
                }
                sector.set((int) sectores.get(i), nuevoTama);
                sectoresArchivo.add(sectores.get(i));
                nuevoTama -= tamSector;
            }  
        }     
        return sectoresArchivo;
    }
    
    public void mismoSectores(ArrayList sectores, int nuevoTama){
        //ArrayList sectoresArchivo = new ArrayList();
        sector.set((int) sectores.get(sectores.size() -1 ), nuevoTama % tamSector);
        
        //return sectoresArchivo;
    }
    
    public void vaciarSectores(ArrayList sectoresA){
        for(int i = 0; i < sectoresA.size() ; i++ ){
            sector.set((int) sectoresA.get(i), 0);
        }
    }
}