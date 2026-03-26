package colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MainColecciones {
    public static void main(String[] args) {

        ArrayList<Integer> arrEnteros = new ArrayList<Integer>();

        arrEnteros.add(13);
        arrEnteros.add(14);
        arrEnteros.add(15);
        arrEnteros.add(16);
        arrEnteros.add(16);

        // Eliminamos elemento
        // No recomendable eliminar elementos de colecciones con FOR, usar ITERATOR
        /*
        for(Integer i : arrEnteros){
            if(i == 15){
                arrEnteros.remove(i); // Remove por objeto
            }
        }

        for( int i = 0 ;i < arrEnteros.size(); i++){
            if(arrEnteros.get(i) == 15){
                arrEnteros.remove(i); // Remove por indice
            }
        }
        */
        /*
        // Listamos elemento
        for(Integer i : arrEnteros){
            System.out.println(i);
        }
        */
        /*
        Iterator<Integer> it = arrEnteros.iterator();


        // Eliminar elementos con iterator
        while (it.hasNext()){
            Integer i = it.next();
            if(i == 16){
                it.remove();
            }
        }

        while (it.hasNext()){
            Integer i = it.next();
            System.out.println(i);
        }
        */
        /*
        LinkedList<String> lt = new LinkedList<String>();

        lt.add("Pepe");
        lt.add("Pepe1");
        lt.add("Pepe2");
        lt.add("Pepe3");
        lt.add("Pepe4");

        for(String name : lt){
            System.out.println(name);
        }
        lt.set(3,"Manuela");

        for(String name : lt){
            if(name.equals("Manuela")){
                name = "Julia"; // No lo modifica
            }
        }
        for( int i = 0 ; i < lt.size() ; i++){
            if(lt.get(i).equals("Manuela")){
                lt.set(i, "Elena"); // Así, si lo modifica
            }
        }

        System.out.println();

        // Creo y recorro con iterator
        Iterator<String> it2 = lt.iterator();

        while(it2.hasNext()){
            if(it2.next().equals("Elena")){
                it2.remove();
            }
            System.out.println(it2.next());
        }
        */
    }
}
