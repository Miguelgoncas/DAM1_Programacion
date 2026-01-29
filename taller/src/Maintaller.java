public class Maintaller {
    public static void main(String[] args) {
        // Creo el motor
    Motor m1 = new Motor(2500, 200);

        // Creo las ruedas y las meto en un array
    Rueda r1 = new Rueda(16, 2.2);
    Rueda r2 = new Rueda(16, 2.2);
    Rueda r3 = new Rueda(16, 2.4);
    Rueda r4 = new Rueda(16, 2.4);
    Rueda[] arrruedasM1 = {r1, r2, r3, r4};

        // Creo las puertas
    Puerta p1 = new Puerta("Delantera Izquierda");
    Puerta p2 = new Puerta("Delantera Derecha");
    Puerta p3 = new Puerta("Porton Trasero");
    Puerta[] arrpuertasM1 = {p1, p2, p3};

        // Construyo el coche
    Coche c1 = new Coche("BMW", "Serie 1", m1, arrruedasM1, arrpuertasM1);

    c1.arrancar();

    if(c1.isEncendido())
        c1.apagar();



    System.out.println(c1.mostrarInfo());


    }
}
