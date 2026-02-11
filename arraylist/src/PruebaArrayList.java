import java.util.ArrayList;
import java.util.LinkedList;

public class PruebaArrayList {
    static void main(String[] args) {
        ArrayList<Persona> personas1 = new ArrayList<>();
        Persona p1 = new Persona("Miguel", 26);
        Persona p2 = new Persona("Antonio", 41);
        personas1.add(p1);
        personas1.add(p2);

        System.out.println(personas1.contains(p1));

        comparadorPersonas cp = new comparadorPersonas();
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
    }
}
