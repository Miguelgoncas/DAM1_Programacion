package colecciones.priority;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MainPriority {
    public static void main(String[] args) {

        CompararEdad compEdad = new CompararEdad();
        CompararApellido compApellido = new CompararApellido();
        CompararDNI compDNI = new CompararDNI();
        CompararNombre compNombre = new CompararNombre();

        PriorityQueue<Persona> pq = new PriorityQueue<Persona>(compEdad.thenComparing(compApellido).thenComparing(compNombre).thenComparing(compDNI));

        Persona p1 = new Persona("12345", "miguel", "gonzalez", 26);
        Persona p2 = new Persona("5678", "elena", "vela", 30);
        Persona p3 = new Persona("987654", "luis", "gonzalez", 45);
        Persona p4 = new Persona("43564754", "alejandro", "gonzlopezlez", 22);
        Persona p5 = new Persona("12345", "miguel", "gonzalez", 29);

        pq.add(p1);
        pq.add(p2);
        pq.add(p3);
        pq.add(p4);
        pq.add(p5);


        Iterator<Persona> it = pq.iterator();

        /* Para poder sacar/ver elemento de una Priority no sirve ni iterator ni forEach, se recorre solo desde el principio
         * se recorre con .poll*/
        /*while(!pq.isEmpty())
            System.out.println(pq.poll().toString());
        */


        /*
        EJERCICIO 8
        PriorityQueue<Integer> pqInt = new PriorityQueue<Integer>();

        Iterator<Integer> itInt = pqInt.iterator();

        pqInt.add(8);
        pqInt.add(3);
        pqInt.add(12);
        pqInt.add(1);
        pqInt.add(6);

        System.out.println(pqInt.peek());
        pqInt.remove();
        System.out.println(pqInt.peek());

        System.out.println();
        while(!pqInt.isEmpty())
            System.out.println(pqInt.poll().toString());

            */

        // Ejercicio 9
        CompararNombrePaciente compararNombrePaciente = new CompararNombrePaciente();
        CompararPrioridad compararPrioridad = new CompararPrioridad();
        PriorityQueue<Paciente> pqPaciente = new PriorityQueue<Paciente>(compararPrioridad.thenComparing(compararNombrePaciente));

        Iterator<Paciente> itPac = pqPaciente.iterator();

        Paciente pa1 = new Paciente("Luis", 3);
        Paciente pa2 = new Paciente("Elena", 3);
        Paciente pa3 = new Paciente("Miguel", 2);
        Paciente pa4 = new Paciente("Alejandro", 1);

        pqPaciente.add(pa1);
        pqPaciente.add(pa2);
        pqPaciente.add(pa3);
        pqPaciente.add(pa4);


        while(!pqPaciente.isEmpty())
            System.out.println(pqPaciente.poll().toString());



        while(!pqPaciente.isEmpty())
            System.out.println(pqPaciente.poll().toString());

    }
}
