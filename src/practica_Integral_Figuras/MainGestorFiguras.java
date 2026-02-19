package practica_Integral_Figuras;

import practica_Integral_Figuras.model.Circulo;
import practica_Integral_Figuras.model.GestorFiguras;
import practica_Integral_Figuras.model.Rectangulo;
import practica_Integral_Figuras.model.Segmento;

import javax.swing.text.Segment;

public class MainGestorFiguras {
    public static void main(String[] args) {
        GestorFiguras gestor = new GestorFiguras();
        Circulo c1 = new Circulo("verde", "rojo", 34);
        Circulo c2 = new Circulo("verde", "rojo", 34);
        Circulo c3 = new Circulo("azul", "amarillo", 25);
        Circulo c4 = new Circulo("morado", "rosa", 13);

        Rectangulo r1 = new Rectangulo("verde", "rojo", 6,3);
        Rectangulo r2 = new Rectangulo("verde", "rojo", 6,3);
        Segmento s1 = new Segmento("violeta",23);
        /*
        gestor.anadirFigura(c1);
        gestor.anadirFigura(c2);
        gestor.anadirFigura(c3);
        gestor.anadirFigura(r1);
        gestor.anadirFigura(s1);
        */

        gestor.dibujarTodas();

        System.out.println(gestor.areaTotal());



        // No son iguales, mismo atributos pero diferente memoria
        if(c1.equals(c2)){
            System.out.println("Son iguales");
        } else{
            System.out.println("No son iguales");
        }
        Circulo c5 = c1;
        // Sin son iguales
        if(c1.equals(c5)){
            System.out.println("Son iguales");
        } else{
            System.out.println("No son iguales");
        }


        if(r1.equals(r2)){
            System.out.println("Son iguales");
        } else{
            System.out.println("No son iguales");
        }



    }
}
