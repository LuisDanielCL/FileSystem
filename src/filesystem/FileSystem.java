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
    Scanner entrada = new Scanner(System.in);
    
    
    public void pedirDatosDisco() {
        if (discoCreado == false)
        {
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
            myFileSystem = new SystemaDeArchivo(nombreDisco);
            System.out.println("Disco creado con exito");
            discoCreado = true;
            
        }else{
            System.out.println("Disco ya creado");
        }       
    }
    
    public void pedirDatosCrearArchivo(DiscoVirtual discoVirtual)
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        if (discoVirtual.sectoresDisponibles()== 0){
            System.out.println("No hay espacio en disco para crear archivos");
            return;
        }
        System.out.print("Ingrese el contenido: ");
        String texto = entrada.nextLine();

        
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = entrada.nextLine();
        if (nombreArchivo.length() == 0)
        {
            System.out.println("Debe ingresar un nombre para el archivo");
            return;
        }
        
        System.out.println("Ingrese la extension del archivo");
        String extension = entrada.nextLine();
        if (extension.equals("TXT") || extension.equals("txt"))
        {
            myFileSystem.crearArchivo(texto, nombreArchivo,"txt",discoVirtual);
        }else{
            System.out.println("Extension no reconocida");
            return;
        }
        
    }
    
    public void pedirDatosCrearDirectorio()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        System.out.print("Ingrese el nombre del directorio: ");
        String nombreDirectorio = entrada.nextLine();
        if (nombreDirectorio.length() == 0)
        {
            System.out.println("Debe ingresar un nombre para el directoiro");
            return;
        }else{
            myFileSystem.crearDirectorio(nombreDirectorio);
        }
    }
    
    public void pedirDatosCambiarDirectorio()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        System.out.print("Ingrese el directorio al que quiere moverse: ");
        String nombreDirectorio = entrada.nextLine();
        if (nombreDirectorio.length() == 0)
        {
            System.out.println("Debe ingresar un nombre de directorio");
            return;
        }else{
            myFileSystem.cambiarDirectorio(nombreDirectorio);
        }
    }
    
    public void volverAtras()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }     
            myFileSystem.volverAtras();
    }
       
    
    public void listarDatosDirectorio()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        myFileSystem.listarDirectorioActual();
    }
    
    public void modificarContenidoArchivo()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        System.out.print("Ingrese el nombre del archivo a modificar: ");
        String nombreArchivo = entrada.nextLine();
        /*Archivo archivo = myFileSystem.getArchivo(nombreArchivo);
        System.out.println(archivo.texto);
        System.out.print("Ingrese el nuevo texto");
        String nuevoTexto = entrada.nextLine();
        archivo.texto = nuevoTexto;
        myFileSystem.actualizarArchivo(archivo)
        */
    }
    
    public void verPropiedadesDeArchivo(DiscoVirtual discoVirtual)
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = entrada.nextLine();
        if (nombreArchivo.length() == 0)
        {
            System.out.println("Debe ingresar un nombre para el archivo");
            return;
        }
        myFileSystem.propiedadesArchivo(nombreArchivo, discoVirtual);
        /*Archivo archivo = myFileSystem.getArchivo(nombreArchivo);
        archivo.printPropiedades();
        */
    }
    
    public void verContenidoArchivo(DiscoVirtual discoVirtual)
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = entrada.nextLine();
        if (nombreArchivo.length() == 0)
        {
            System.out.println("Debe ingresar un nombre para el archivo");
            return;
        }
        myFileSystem.contenidoArchivo(nombreArchivo, discoVirtual);
        /*Archivo archivo = myFileSystem.getArchivo(nombreArchivo);
        String texto = arhchivo.getTexto();
        System.out.println(texto);
        */
    }
    
    public void copiarArchivo()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        System.out.print("Ingrese la ruta del archivo a ser copiado: ");
        String rutaInicio = entrada.nextLine();
        System.out.print("Ingrese la ruta donde se desea copiar: ");
        String rutaFin = entrada.nextLine();
        
        if (rutaInicio.length() == 0 || rutaFin.length() == 0)
        {
            System.out.println("Debe ingresar los datos solicitados");
        }else{
            //myFileSystem.copiarArchivo(rutaInicio, rutafin);
        }
    }
    
    public void moverArchivo()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        System.out.print("Ingrese la ruta donde mover el directorio:");
        String nuevaRuta = entrada.nextLine();
        System.out.print("Ingrese el nombre del directorio/archivo: ");
        String nombreArchivo = entrada.nextLine();
        System.out.print("Ingrese el nuevo nombre del directorio: ");
        String nuevoNombre = entrada.nextLine();
        
        if (nombreArchivo.length() == 0 || nuevaRuta.length() == 0 ||
                nuevoNombre.length() == 0)
        {
            System.out.println("Debe ingresar los datos solicitados");
        }else{
            String[] nombreList = nombreArchivo.split("\\.", 2);
            if(nombreList.length>1){
                if(nombreList[1].toUpperCase().equals("TXT")){
                    myFileSystem.moverArchivo(nombreList[0],nuevaRuta,
                            nuevoNombre,discoVirtual);
                }
            }else{
                myFileSystem.moverDirectorio(nombreArchivo,nuevaRuta,
                            nuevoNombre,discoVirtual);
            }
            /*if (myFileSystem.esArchivo(nombre)
            {
                myFileSystem.moverArchivo(rutaInicio, rutaFin);
            }else if (myFileSystem.esDirectorio(rutaInicio, rutaFin)
            {
                myFileSystem.moverDirectorio(nombre
            }
            */
        }
    }
    
    public void removerArchivo()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        System.out.print("Ingrese el nombre del archivo o directorio: ");
        String nombre = entrada.nextLine();
        if (nombre.length() == 0)
        {
            System.out.println("Debe ingresar un nombre");
        }else{
            String[] nombreList = nombre.split("\\.", 2);
            if(nombreList.length>1){
                if(nombreList[1].toUpperCase().equals("TXT")){
                    myFileSystem.eliminarArchivo(nombreList[0],discoVirtual);
                }
            }else{
                myFileSystem.eliminarDirectorio(nombre,discoVirtual);
            }
            

        }
    }
    
    public void mostrarEstructuraVolumen()
    {
        if (discoCreado == false)
        {
            System.out.println("Disco virtual no creado");
            return;
        }
        
        //myFileSystem.mostrarEstructuraVolumen();
    }
    
    
    private void mostrarEstructuraActual() {
        myFileSystem.mostrarEstructuraActual();
    }
    
    
    public void esperarComandos()
    {
        System.out.println("=====Sistema de archivos=====");
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar)
        {
            if(discoCreado){
                System.out.print(myFileSystem.getRuta()+">");
            }else{
                System.out.print(">");
                
            }
            
            String comando = entrada.nextLine();
            switch (comando.toUpperCase())
            {
                case "CRT":
                    pedirDatosDisco();
                    break;
                    
                case "FLE":
                    pedirDatosCrearArchivo(discoVirtual);
                    break;
                    
                case "MKDIR":
                    pedirDatosCrearDirectorio();
                    break;
                    
                case "CHDIR":
                    pedirDatosCambiarDirectorio();
                    break;
                    
                case "LDIR":
                    listarDatosDirectorio();
                    break;
                   
                case "MFLE":
                    modificarContenidoArchivo();
                    break;
                    
                case "PPT":
                    verPropiedadesDeArchivo(discoVirtual);
                    break;
                
                case "VIEW":
                    verContenidoArchivo(discoVirtual);
                    break;
                 
                case "CPY":
                    copiarArchivo();
                    break;
                    
                case "MOV":
                    moverArchivo();
                    break;
                    
                case "REM":
                    removerArchivo();
                    break;
                
                case "TREE":
                    mostrarEstructuraVolumen();
                    break;
                    
                case "TREET":
                    mostrarEstructuraActual();
                    break;
                    
                case "BACK":
                    volverAtras();
                    break;
                 
                case "EXIT":
                    continuar = false;
                    
                default:
                    System.out.println("Comando invalido");
                    System.out.println("Comandos validos: ");
                    String comandos = "CRT (Crear disco)\n"
                            + "FLE (Crear archivo)\n"
                            + "MKDIR (Crear directorio)\n"
                            + "CHDIR (Cambiar de directorio)\n"
                            + "BACK (Volver al directorio previo)\n"
                            + "LDIR (Listar contenidos de directorio)\n"
                            + "MFLE (Mofificar contenido de archivo)\n"
                            + "PPT (Ver propiedades de archivo)\n"
                            + "VIEW (Ver contenido de archivo)\n"
                            + "CPY (Copiar archivos o directorios)\n"
                            +"MOV (Mover archivos o directorios)\n"
                            + "REM (Remover archivos o directorios\n"
                            + "TREE (Mostrar estructura logical de FS)\n"
                            + "EXIT (Salir del programa)\n";
                    System.out.println(comandos);
                    break;
            }
        }
    }
    
    public static void main(String[] args) {

        //vacios = new LinkedList();
        //ocupados = new LinkedList();
        
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
