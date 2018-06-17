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
    //static LinkedList vacios;
    //static LinkedList ocupados;
    static DiscoVirtual discoVirtual;
    static SystemaDeArchivo myFileSystem;
    
    boolean discoCreado = false;
    
    
    public void pedirDatosDisco() {
        if (discoCreado == false)
        {
            Scanner entrada  = new Scanner(System.in);
            System.out.print("Digite el nombre del Disco Virtual: ");
            String nombreDisco = entrada.nextLine();
            if (nombreDisco.length() == 0)
            {
                System.out.println("Debe ingresar un nombre para el disco");
                return;
            }
        
            int tamanoSector;
            System.out.print("Digite el tamaño del sector: ");
            if (entrada.hasNextInt())
            {
                tamanoSector = entrada.nextInt();
            }else{
                System.out.println("Debe ingresar un tamano entero");
                return;
            }
        
            int cantSectores;
            System.out.print("Digite la cantidad de sectores: ");
            if (entrada.hasNextInt())
            {
                cantSectores = entrada.nextInt();
                if (cantSectores <= 0)
                {
                    System.out.println("debe ingresar una cantidad mayor que cero");
                    return;
                }
            }else{
                System.out.println("Debe ingresar una cantidad entera");
                return;
            }
            discoVirtual = new DiscoVirtual(nombreDisco, tamanoSector, cantSectores);
            discoVirtual.setTamDiscoV();
            discoVirtual.crearRespaldo();
            System.out.println("Disco creado con exito");
            discoCreado = true;
            
        }else{
            System.out.println("Disco ya creado");
        }       
    }
    
    public void esperarComandos()
    {
        System.out.println("=====Sistema de archivos=====");
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar)
        {
            String comando = entrada.nextLine();
            switch (comando)
            {
                case "CRT":
                    pedirDatosDisco();
            }
        }
    }
    
    public static void main(String[] args) {

        //vacios = new LinkedList();
        //ocupados = new LinkedList();
        myFileSystem = new SystemaDeArchivo();
        
        FileSystem instancia = new FileSystem();
        instancia.esperarComandos();
        
        
        
        /*System.out.print(myFileSystem.SystemaDeArchivos);

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
