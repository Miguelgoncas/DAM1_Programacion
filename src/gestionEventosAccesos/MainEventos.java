package gestionEventosAccesos;


import gestionEventosAccesos.gestionAsistentes.Asistentes;
import gestionEventosAccesos.gestionAsistentes.Estudiantes;
import gestionEventosAccesos.gestionEventos.EventoPresencial;
import gestionEventosAccesos.gestionEventos.Eventos;
import gestionEventosAccesos.service.GestorEventos;
import gestionEventosAccesos.service.Inscripcion;

import java.util.Scanner;

public class MainEventos  {
    static void main(String[] args) {
        GestorEventos gd = new GestorEventos();
        Scanner rd = new Scanner(System.in);

        Eventos evento1 = new EventoPresencial("001","Programacion","23/02/2026",10, 70,"Jaén");
        Asistentes a1 = new Estudiantes("dni1","miguel","miguelgon");

        System.out.println(a1.calcularDinero(10));


        System.out.println(gd.registrarInscripciones("001","dni1") ? "Registrado" : "No registrado");
        System.out.println(gd.registrarInscripciones("001","dni1") ? "Registrado" : "No registrado");
        /*
        int opc = 0;
        do{
            System.out.println("1. Registrar asistente");
            System.out.println("2. Registrar evento");
            System.out.println("3. Inscribir asistente a evento");
            opc = rd.nextInt();
            switch (opc){
                case 1:
                    System.out.println("1. Registrar estudiante");
                    System.out.println("2. Registrar ponente");
                    System.out.println("3. Registrar publico general");
                    int opc1 = 0;
                    opc1 = rd.nextInt();
                    switch (opc1){
                        case 1:
                            System.out.println("Introduce el dni");
                            String dni1 = rd.next();
                            System.out.println("Introduce el nombre");
                            String nom1 = rd.next();
                            System.out.println("Introduce email");
                            String email1 = rd.next();
                            Asistentes a1 = new Estudiantes(dni1,nom1,email1);


                    }
            }


        }while (opc != 0);

        */
    }
}
