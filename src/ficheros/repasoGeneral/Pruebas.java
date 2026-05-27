package ficheros.repasoGeneral;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Pruebas {
    public static void main(String[] args) {

        String ruta2 = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\";
        File file2 = new File(ruta2, "fichero_personas.txt");

        FileReader fr = null;
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(file2));

            String linea;

            while((linea = br.readLine()) != null){

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
