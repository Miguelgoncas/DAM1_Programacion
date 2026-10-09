package ficheros.repasoGeneral;




import java.io.*;
import java.util.ArrayList;


public class RepasoFicheros {
    final static String ruta = "C:\\Users\\Usuario\\Desktop\\";
    final static String FILE_NAME = "fichero_personas.txt";
    final static String FILE_OUTPUT = "fichero_personasOut.txt";
    final static String SEPARATOR = ";";

    static void main(String[] args) {

        File f = new File(ruta, FILE_NAME);
        ArrayList<Persona> arrPersona = new ArrayList<>();

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea;

            while( (linea = br.readLine()) != null){
                String [] campos = linea.split(SEPARATOR);
                arrPersona.add(createPersona(campos));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error, fichero no encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }




        FileWriter fw = null;
        BufferedWriter bw = null;

        File fOut = new File(ruta, FILE_OUTPUT);
        try{
            fw = new FileWriter(fOut);
            bw = new BufferedWriter(fw);

            for( Persona p : arrPersona){
                String registro =
                                getStringWithComa(p.getDni()) +
                                getStringWithComa(p.getNombre())  +
                                getStringWithComa(p.getApellidos()) +
                                getString(p.getEdad()) + "\n";
                StringBuilder sb = new StringBuilder();
                sb.append(p.getDni()).append(",");
                sb.append(p.getNombre()).append(",");
                sb.append(p.getApellidos()).append(",");
                sb.append(p.getEdad());
                sb.append("\n");


                System.out.print("[sb]: " + sb);

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


    }

    private static Boolean checkString(String value){

        return value != null && !value.isEmpty();
    }

    private static String getString(int value){
        String valueString = value + "";
        return checkString(valueString) ? valueString : "";
    }
    private static String getStringWithComa(String value) {
        return checkString(value) ? value + "," : "";
    }

    private static Persona createPersona(String[] campos) {
        String dni = campos[0];
        String nombre = campos[1];
        String apellido = campos[2];
        int edad = Integer.parseInt(campos[3]);

        return new Persona(dni,nombre,apellido,edad);
    }
}
