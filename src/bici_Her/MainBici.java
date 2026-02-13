package bici_Her;

public class MainBici {
    public static void main(String[] args) {
    Bicicleta[] tienda = {new Bicicleta(),
            new Bicicleta_Tandem(100,5,2),
            new Bicicleta_Montania(80,3,1,4)};
    for( Bicicleta b : tienda){
        b.acelerar();
        System.out.println(b.toString() +
                " tipo: " +  b.getClass() +
                " \n" );
    }

    }
}
