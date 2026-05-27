package colecciones;

import java.util.Iterator;
import java.util.LinkedList;

public class ColeccionCoches {
    public static void main(String[] args) {
        LinkedList<Coche> lt = new LinkedList<Coche>();

        Coche c1 = new Coche("Seat","Rojo");
        Coche c2 = new Coche("Opel","Negro");
        Coche c3 = new Coche("BMW","Amarillo");
        Coche c4 = new Coche("Dacia","Verde");


        lt.add(c1);
        lt.add(c2);
        lt.add(c3);
        lt.add(c4);

        for(Coche c: lt){
            System.out.println(c.toString());
        }


        for(Coche c: lt){
            if(c.getMarca().equals("Opel")){
                c.setMarca("BMW");
            }
        }

        System.out.println();
        // Muestro la lista modificada
        for(Coche c: lt){
            System.out.println(c.toString());
        }

    }
}
