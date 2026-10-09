package ficheros.ejercicioBinarioSerializable;

import java.io.*;
import java.util.ArrayList;

public class EjercicioBinarioSerializable {
    static void main(String[] args) {

        LecturaFichero lF = new LecturaFichero();
        EscrituraFichero eF = new EscrituraFichero();

        Persona p1 = new Persona("123456","Luis"
                ,"Barcenas",68);

        // Agrego a una persona
        eF.agregarPersona(p1);

        // Busco en el fichero según dni
        System.out.println("Persona según dni");
        lF.buscarDNI("123456");

        System.out.println("Leemos a las personas");
        eF.guardarPersonas();
        lF.leerPersonas();
    }
}
