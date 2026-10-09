package colecciones.treeSett;

import colecciones.priority.Persona;

import java.util.TreeSet;

public class MainTreeSet {
    public static void main(String[] args) {
        TreeSet<Persona> ts = new TreeSet<Persona>();

        /*
        Persona p1 = new Persona("12345", "miguel", "gonzalez", 26);
        Persona p2 = new Persona("5678", "elena", "vela", 30);
        Persona p3 = new Persona("987654", "luis", "gonzalez", 45);
        Persona p4 = new Persona("43564754", "alejandro", "lopez", 22);
        Persona p5 = new Persona("12345", "miguel", "gonzalez", 29);


        ts.add(p1);
        ts.add(p2);
        ts.add(p3);
        ts.add(p4);
        ts.add(p5);

        // Para recorrer un TreeSet

        for (Persona p : ts) {
            System.out.println(p.toString());
        }
        */
        // Ejercicio 13

        TreeSet<Integer> tsInteger = new TreeSet<Integer>();

        tsInteger.add(9);
        tsInteger.add(3);
        tsInteger.add(5);
        tsInteger.add(1);
        tsInteger.add(7);

        for(Integer in : tsInteger){
            System.out.println(in.toString());
        }

        // Ejercicio 14
        TreeSet<String> tsString = new TreeSet<String>();

        tsString.add("Miguel");
        tsString.add("Elena");
        tsString.add("Alejandro");
        tsString.add("Luis");
        tsString.add("David");

        for(String st : tsString) {
            System.out.println(st);
        }

        // Ejercicio 15

        TreeSet<Double> tsDouble = new TreeSet<Double>();

        tsDouble.add(5.5);
        tsDouble.add(7.3);
        tsDouble.add(9.1);
        tsDouble.add(4.2);
        tsDouble.add(7.3);

        for(Double dou : tsDouble){
            System.out.println(dou.toString());
        }

        System.out.println("La más alta " + tsDouble.getLast());
        System.out.println("La más baja " + tsDouble.getFirst());
    }
}
