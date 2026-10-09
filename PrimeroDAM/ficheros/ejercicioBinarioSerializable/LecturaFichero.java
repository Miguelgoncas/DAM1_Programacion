package ficheros.ejercicioBinarioSerializable;

import colecciones.priority.CompararEdad;

import java.io.*;
import java.util.PriorityQueue;

public class LecturaFichero {
    private String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\ejercicioBinarioSerializable";
    private File f = new File(ruta, "personas.dat");

    // Declaramos iniciador
    private FileInputStream fis;
    // Declaramos filtro
    private  ObjectInputStream ois;

    public LecturaFichero(){

    }

    public void leerPersonas(){
        PriorityQueue<Persona> pqPersona = new PriorityQueue<>();
        try{
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);


            while (fis.available() != 0) {
                Persona p;
                p = (Persona) ois.readObject();
                pqPersona.add(p);


                while(!pqPersona.isEmpty()){
                    System.out.println(pqPersona.poll().toString());
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fichero no encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void buscarDNI(String dni){
         PriorityQueue<Persona> pqPersona = new PriorityQueue<Persona>();

        try{
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);


            while (fis.available() != 0) {
                Persona p;
                p = (Persona) ois.readObject();
                if( p.getDni().equals(dni)) {
                    pqPersona.add(p);

                    for( Persona pe : pqPersona){
                        System.out.println(pe.toString());
                    }
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fichero no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
