package ficheros.repasoGeneral.alumno;

import java.io.*;
import java.util.ArrayList;

public class AlumnoFichero {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\repasoGeneral\\alumno\\";
        File f = new File(ruta, "alumnos.txt");

        FileReader fr = null;
        BufferedReader br = null;


        ArrayList<Alumno> arrAlum = new ArrayList<>();
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea;

            while((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");

                String dni = campos[0];
                String nombre = campos[1];
                String apellido = campos[2];
                double nota = Double.parseDouble(campos[3]);

                Alumno alum = new Alumno(dni,nombre,apellido,nota);
                arrAlum.add(alum);
            }
            arrAlum.forEach(System.out::println);

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


        File f2 = new File(ruta, "alumnosAprobado.txt");

        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fw = new FileWriter(f2);
            bw = new BufferedWriter(fw);

            for (Alumno a : arrAlum){
                Alumno registro = new Alumno(a.getDni(), a.getNombre(),a.getApellido(), a.getNota());
                bw.write(String.valueOf(registro));
                bw.newLine();
            }
            // arrAlum.removeIf(a -> a.getNota() < 5);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}



