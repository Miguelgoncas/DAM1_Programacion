package SegundoDAM.ProgServicios.ProcesosR1;

import java.io.IOException;

public class EjecucionProcesos {
    public static void main(String[] args) {

        String ruta = "C:\\Program Files\\MySQL\\MySQL Workbench 8.0\\MySQLWorkbench.exe";

        ProcessBuilder pb = new ProcessBuilder(ruta);

        /* Todo proceso tiene su id*/
        try {
            Process proceso = pb.start();
            System.out.println("Este es el id del proceso en ejecucion " + proceso.pid());
        } catch (IOException e) {
            System.err.println("No se puede lanzar el proceso" + e.getMessage());
        }

    }
}
