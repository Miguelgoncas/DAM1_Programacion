package colecciones;

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrEnteros = new ArrayList<Integer>();

        arrEnteros.add(1);
        arrEnteros.add(2);
        arrEnteros.add(3);
        arrEnteros.add(4);
        arrEnteros.add(5);
        arrEnteros.add(6);
        arrEnteros.add(7);
        arrEnteros.add(8);
        arrEnteros.add(9);
        arrEnteros.add(10);

        System.out.println("Muestro todos los elementos");
        for(Integer i : arrEnteros){
            System.out.println(i);
        }
        int mayor = arrEnteros.getFirst();
        for(Integer i : arrEnteros){
            if(arrEnteros.get(i) > mayor){
                mayor = i;
            }

        }

        System.out.println(mayor);

    }
}
