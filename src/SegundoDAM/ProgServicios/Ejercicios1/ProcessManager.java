package SegundoDAM.ProgServicios.Ejercicios1;

import java.io.IOException;

public class ProcessManager {
    public static void main(String[] args) {

        // Creo tres rutas a tres aplicaciones diferentes
        String ruta1 ;
        String ruta2  ;
        String ruta3 ;

        ProcessBuilder pbr1 = new ProcessBuilder();
        ProcessBuilder pbr2 = new ProcessBuilder();
        ProcessBuilder pbr3 = new ProcessBuilder();

        // Procedemos a ejecutar los procesos
        try {
            pbr1.start();
            pbr2.start();
            pbr3.start();
        } catch (IOException e) {
            System.err.println("No se puede lanzar el proceso " + e.getMessage());
        }


    }
}
