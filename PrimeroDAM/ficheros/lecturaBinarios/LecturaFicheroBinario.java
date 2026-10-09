package ficheros.lecturaBinarios;
import ficheros.Persona;
import java.io.*;
import java.util.ArrayList;

public class LecturaFicheroBinario {
    static void main(String[] args) {
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\lecturaBinarios";
        File f = new File(ruta, "ficheroBinarioPersona.dat");

        ArrayList<Persona> arrPersona = new ArrayList<Persona>();
        // Declaramos iniciador
        FileInputStream fout = null;

        // Declaramos filtro
        ObjectInputStream ois = null;

        try {
            fout = new FileInputStream(f);
            ois = new ObjectInputStream(fout);

            // fout.available(); // Nos dice el número de bytes que quedan por leer
            System.out.println("Bytes disponibles: " + fout.available());

            while(ois.available() > 0){ // Mientras haya bytes por leer, se sigue leyendo

                // Leemos la información dentro del fichero y lo guardamos en una variable
                String dni = ois.readUTF();
                String nombre = ois.readUTF();
                String apellidos = ois.readUTF();
                int edad = ois.readInt();
                double salario = ois.readDouble();
                Persona p1  = new Persona(dni,nombre,apellidos,edad,salario);
                arrPersona.add(p1);
                System.out.println(p1 + ", salario " + salario);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                ois.close();
                fout.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
