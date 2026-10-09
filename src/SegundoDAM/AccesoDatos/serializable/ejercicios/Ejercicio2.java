package SegundoDAM.AccesoDatos.serializable.ejercicios;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    static void main(String[] args) {
        // Creamos serializador
        ObjectOutputStream serializador = null;
        // Creamos lista
        List<Persona> personas = new ArrayList<Persona>();
        // Añadimos personas a la lista
        personas.add(new Persona("Miguel", "Miguel@gmail.com", 2000));
        personas.add(new Persona("Alejandro", "delegado@dictadura.com", 2004));
        personas.add(new Persona("Gabriel", "Gabri@hotmail.com", 2004));

        // Creamos fichero
        File perso = new File("C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\serializable\\ejercicios\\personas.dat");

        // Escribimos en el fichero
        try {
            serializador = new ObjectOutputStream(new FileOutputStream(perso));

            serializador.writeObject(personas);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Procedemos a leer el fichero, creamos otra lista

        List<Persona> personas2 = new ArrayList<Persona>();

        ObjectInputStream deserializador = null;

        try {
            // Creamos deserializador y lo iniiamos con FileInputStream
            deserializador = new ObjectInputStream(new FileInputStream(perso));

            // Hacemos casting y lo leemos de la lista
            personas2 = (List<Persona>) deserializador.readObject();

            for( int i = 0; i < personas2.size(); i++) {
                JOptionPane.showMessageDialog(null, personas2.get(i).toString());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
