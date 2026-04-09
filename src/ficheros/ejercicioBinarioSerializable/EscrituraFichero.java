package ficheros.ejercicioBinarioSerializable;

import java.io.*;

public class EscrituraFichero {

        private String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\ejercicioBinarioSerializable";
        private File f = new File(ruta, "personas.dat");

        private FileOutputStream fos; // iniciador
        private ObjectOutputStream oos; // filtro

    public EscrituraFichero(){

    }
        public void guardarPersonas(){
            // Creamos personas
            Persona p1 = new Persona("775456", "Miguel",
                    "Gonzalez",16);
            Persona p2 = new Persona("789", "Elena",
                    "Vela",45);
            Persona p3 = new Persona("123", "Luis",
                    "Barcenas",30);
            Persona p4 = new Persona("456", "Miriam",
                    "Gonzalez",26);

            try {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

                oos.writeObject(p1);
                oos.writeObject(p2);
                oos.writeObject(p3);
                oos.writeObject(p4);

            } catch (
                    FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }


        }

        public void agregarPersona(Persona p1){
            try {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

                oos.writeObject(p1);
            } catch (
                    FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }


}
