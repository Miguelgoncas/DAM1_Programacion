package ficheros.repasoGeneral.ventas;

import java.io.*;
import java.util.ArrayList;

public class LecturaFichero {
    public static void main(String[] args) {
        String ruta ="C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\repasoGeneral\\ventas\\";
        File f = new File(ruta, "ventas.txt");

        ArrayList<Producto> productos = new ArrayList<>();

        FileReader fr = null;
        BufferedReader br = null;
        FileInputStream fis = null;
        FileWriter fw = null;
        String linea;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            fw = new FileWriter(f,true);

            fw.write("portatil" + "," + "2200" + ","+ "1" + "\n");
            fw.write("monitor" + "," + "300" + ","+ "1" + "\n");
            fw.write("teclado" + "," + "50" + ","+ "1" + "\n");

            while((linea = br.readLine()) != null){
                if(linea.startsWith("producto")) continue;

                String[] partes = linea.split(",");
                String nombre = partes[0];
                double precio = Double.parseDouble(partes[1]);
                int cantidad = Integer.parseInt(partes[2]);
                System.out.println(partes[0] + " " + partes[1] + " " + partes[2] );
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                fr.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
