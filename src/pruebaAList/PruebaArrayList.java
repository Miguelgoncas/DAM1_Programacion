package pruebaAList;

import java.util.*;

public class PruebaArrayList {
    public static void main(String[] args) {
        Persona p1 = new Persona("Miguel", 26);
        Persona p2 = new Persona("Antonio", 41);



        // Creo arrayList, agrego p1 y agrego p2 e imprimo
        ArrayList<Persona> personas1 = new ArrayList<>();
        personas1.add(p1);
        personas1.add(p2);
        System.out.println(personas1.contains(p1));

        ArrayList<Persona> personasAll = new ArrayList<>();
        personasAll.addAll(personas1);


        // Creo un ArrayList inicializado con una lista de p1 y p2
        ArrayList<Persona> personasOf = new ArrayList<>(List.of(p1,p2));
        System.out.println(personasOf.get(0));
        personasOf.remove(0);
        System.out.println(personasOf.get(0));

        ArrayList<Persona> personasOf2 = new ArrayList<>(Arrays.asList(p1, p2));


        // HashSet es una lista que no permite repetidos
        Set<Persona> personaSet = new HashSet<>();
        personaSet.addAll(Arrays.asList(p1,p2));
        personaSet.add(p1);
        // Añadimos repetido pero como no permite, al imprimir no saldrá
        personaSet.add(new Persona("Carlos", 33));

        System.out.println("personaSet = " + personaSet);


        ComparadorPersonas cp = new ComparadorPersonas();
        personas1.sort(cp);

        for(Persona p : personas1){
            //System.out.println(p);
        }



        LinkedList <Persona> personas2 = new LinkedList<>();
        personas2.add(p1);
        personas2.add(p2);
        for(Persona p : personas2) {
            System.out.println(p);
        }



        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(0,"cero");
        myMap.put(1,"uno");
        myMap.put(3,"tres");
        System.out.println(myMap.get(3));
        System.out.println(myMap.values());

    }
}
