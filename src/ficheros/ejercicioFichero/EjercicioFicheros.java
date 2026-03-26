package ficheros.ejercicioFichero;
import ficheros.Persona;
import java.io.*;
import java.util.ArrayList;

public class EjercicioFicheros {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\";


        // Creo un objeto fichero con el path del fichero a leer
        File f = new File(ruta, "fichero_personas.txt");

        // Creo un nuevo fichero para guardar a los mayores de edad
        File newFile = new File(ruta, "ficheroMayoresEdad.txt");

        // Creo ArrayList
        ArrayList<Persona> arrPersona = new ArrayList<Persona>();

        // Creo un String linea para almacener la información del fichero
        String linea;

        // Creo el FileReader y BufferedReader para inicializarlo más tarde
        FileReader fr = null;
        BufferedReader br = null;

        // Creo el try-catch
        try {
           fr = new FileReader(f); // Inicializo FileReader y BufferedReader
           br = new BufferedReader(fr);

           // Usamos el BufferedReader para ir metiendo la información en un array
           while( (linea = br.readLine()) != null){
               String [] campos = linea.split(",");
               String dni = campos[0];
               String nombre = campos[1];
               String apellidos = campos[2];
               int edad = Integer.parseInt(campos[3].trim());
               Persona p = new Persona(dni, nombre, apellidos, edad);
               arrPersona.add(p);
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException("Error al leer el fichero");
            }

        }

        // Añadir persona
        Persona p1 = new Persona("12345A","Miguel", "González Castillo", 26);
        arrPersona.add(p1);

        // Buscar por DNI
        System.out.println("Buscar por DNI");
        String dni = "12345A";
        boolean encontrado = false;

        for(Persona p : arrPersona){
            if(p.getDni().equals(dni)){
                System.out.println(p.toString());
                encontrado = true;
            }
        }

        if(!encontrado)
            System.out.println("Persona no encontrada");


        // Mostrar personas mayores de edad
        int mayorEdad = 18;

        for( Persona p : arrPersona){
            if (p.getEdad() > mayorEdad){
                System.out.println(p);
            }
        }

        // Guardar cambios fichero sobreescribiendo
        // Creo el File y el Buffer para escribir ficheros
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
             fw = new FileWriter(f);
             bw = new BufferedWriter(fw);

            for( Persona p : arrPersona){
                String registro = (p.getDni() + "," + p.getNombre()
                        + "," + p.getApellidos() + "," + p.getEdad() + "\n");
                bw.append(registro);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Creamos fichero solo con los mayores de edad

        try{
            fw = new FileWriter(newFile);
            bw = new BufferedWriter(fw);

                for( Persona p : arrPersona){
                    if (p.getEdad() > mayorEdad){
                        String registro = p.getDni() + "," +
                                p.getNombre() + "," +
                                p.getApellidos() + "," +
                                p.getEdad() + "\n";
                        bw.append(registro);
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
