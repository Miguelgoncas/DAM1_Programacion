package ficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class LecturaFichero {
    static void main(String[] args) {
        // Creamos un String para guardar la ruta y no tener que copiarla, sin el fichero
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\";

        //Creamos un objeto File
        File f = new File("C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\fichero_personas.txt");
        // También se puede hacer copiando la ruta y poniendo el archivo debido que hay muchos constructores
        File f1 = new File( ruta, "fichero_personas.txt");

        File ford = new File(ruta, "fichero_per_ordena.txt");
        // Creamos un fichero ordenado


        // Creamos un objeto de FileReader para leer un fichero
        FileReader fr = null;

        BufferedReader br = null;


        String linea;
        ArrayList<Persona> arrPersona = new ArrayList<Persona>();

        // Creo Priority y le paso para que lo ordene por apellido
        PriorityQueue<Persona> pqPersona = new PriorityQueue<Persona>(new CompararApellido()); // Si quieres que sea inversa, .reversed()


        arrPersona.forEach(System.out::println);
         // Lectura del fichero
        try {
            fr = new FileReader(f); // Leemos el fichero
            br = new BufferedReader(fr); // Guardamos la información del fichero y se almacena en el Buffer

            while((linea = br.readLine()) != null){
                String[] campos = linea.split(","); // linea.split separa y guarda en el array cada valor separado por "," coma.

                // Accedemos a cada parte
                String dni = campos[0];
                String nombre = campos[1];
                String apellidos = campos[2];
                int edad = Integer.parseInt(campos[3]);
                Persona p = new Persona(dni, nombre, apellidos, edad);
                arrPersona.add(p);
            }

            for( Persona p : arrPersona){
                // System.out.println(p.toString());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Ordenar array
        // Uso el PriorityQueue y le paso la colección del ArrayList
        pqPersona.addAll(arrPersona);

        /*
        while (!pqPersona.isEmpty()) { // Sale ordenado por apellido
            System.out.println(pqPersona.poll().toString());
        }
        */





        // Escritura del fichero ordenado
        // Creamos un FileWritter para poder escribir en un fichero
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(ford); // Inicializamos los objetos
            bw = new BufferedWriter(fw);

            // Mientras el Priority no este vacio, vamos leyendo y concatenando los datos, y con bw guardamos en el fichero
            while (!pqPersona.isEmpty()){
                Persona p = pqPersona.poll();
                String registro = p.getDni() + "," + p.getNombre() + ","
                        + p.getApellidos() + "," + p.getEdad() + "\n";
                bw.append(registro);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close(); // Primero cerrar siempre el Buffer
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
