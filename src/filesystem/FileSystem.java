package filesystem;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author kurayami
 */

public class FileSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList vacios = new LinkedList();
        LinkedList ocupados = new LinkedList();
        DiscoVirtual discoVirtual = new DiscoVirtual();
        SystemaDeArchivo myFileSystem = new SystemaDeArchivo();
        System.out.print(myFileSystem.SystemaDeArchivos);
        myFileSystem.setSystemaDeArchivos(new Directorio("porno"));
        myFileSystem.setCurrent("actual");
        myFileSystem.setRoot("root");
        myFileSystem.setRutaA("A");
        myFileSystem.setSystemaDeArchivos(new Directorio("Luis"));
        myFileSystem.setCurrent("actual");
        myFileSystem.setRoot("root");
        myFileSystem.setRutaA("A");
        
        Object a = myFileSystem.SystemaDeArchivos.getFirst();
        if (a instanceof Directorio)
            {
                Directorio d = (Directorio)a;
                Archivo roger = new Archivo();
                roger.nombre = "Manrique";
                
                Archivo jose = new Archivo();
                jose.nombre = "Jose";
                //d.agregarArchivo("jorge");
                d.contenido.add(jose);
                d.contenido.add(roger);
                Object primero = d.contenido.getFirst();
                if (primero instanceof Archivo)
                {
                    //Archivo primerArchivo = (Archivo) primero;
                    //System.out.println(primerArchivo.nombre);
                }
                //System.out.println(Arrays.deepToString(d.contenido.toArray()));
                d.verDirectorio();
                d.removerArchivo("Manrique");
                d.verDirectorio();
                //System.out.println(Arrays.deepToString(d.contenido.toArray()));
            }
        
        
        System.out.println(a instanceof Directorio);
        //CRT
        Scanner entrada  = new Scanner(System.in);
        
        
        System.out.print("Digite el nombre del Disco Virtual: ");
        discoVirtual.setNombre(entrada.nextLine());
        System.out.println();
        System.out.print("Digite el tamaño del sector: ");
        discoVirtual.setTamSector(entrada.nextInt());
        System.out.println();
        System.out.print("Digite la cantidad de sectores: ");
        discoVirtual.setNumSectores(entrada.nextInt());
        System.out.println();
        //discoVirtual.getNombre();
        discoVirtual.setTamDiscoV();
        discoVirtual.crearRespaldo();
        //fin del CRT
        
        for (int i = 0; i < discoVirtual.getNumSectores(); i++){
            vacios.add(i);
        }
        
        
        System.out.println(vacios);
        
        //FLE
        
        
        
        /*
        LinkedList lista = new LinkedList();
        //ArrayList<Integer> arrli = new ArrayList<Integer>();
        //ArrayList<Boolean> mapa =  new ArrayList<Boolean>();

        lista.add(1);
        lista.add(2);
        lista.add(4);
        lista.add(5);
        lista.add(3);
       
        //Collections.sort(lista); ordena lista numerica
        System.out.print(lista);
        */
    }
}
