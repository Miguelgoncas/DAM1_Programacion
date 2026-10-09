package SegundoDAM.AccesoDatos.serializable.ejercicios;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    static void main(String[] args) {
        // Creamos serializador
        ObjectOutputStream serializador = null;

        // Creamos una lista de ciudades
        List<Ciudad> ciudades = new ArrayList<Ciudad>();

        // Agreamos las ciudades
        ciudades.add(new Ciudad(1, "Jaén"));
        ciudades.add(new Ciudad(2, "Granada"));
        ciudades.add(new Ciudad(3, "Toledo"));

        // Creamos fichero binario
        File ciud = new File("C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\serializable\\ejercicios\\ciudades.dat");

        try {
            // inicio serializador con FileInputStream
            serializador = new ObjectOutputStream(new FileOutputStream(ciud));
            // Usamos su metodo de writeObject
            serializador.writeObject(ciudades);
            // HEmos serializado y guardado las ciudades en el archivo

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                serializador.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        // Ahora que está guardado procedemos a mostrarlo

        // Declaramos el deserializador y creamos una lista nueva para almacenar los objetos
        ObjectInputStream deserializador = null;
        List<Ciudad> ciudades2 = new ArrayList<Ciudad>();

        try {
            deserializador = new ObjectInputStream(new FileInputStream(ciud));
            ciudades2 = (ArrayList<Ciudad>) deserializador.readObject();
            // hacemos cast para meterlo en la lista nueva

            // Recorremos y mostramos con un for
            for ( int i = 0; i < ciudades2.size(); i++){
                JOptionPane.showMessageDialog(null, ciudades2.get(i).toString());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                deserializador.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
