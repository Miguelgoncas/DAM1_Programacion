package ejerciciosExcepciones;

public class Ejercicio9 {
    static void main(String[] args)  {
        double saldo = 0;
        depositar(saldo,500);

        try {
            retirar(saldo,700);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMensaje());
        }

    }


    public static void depositar(double saldo, double cantidad){
        saldo += cantidad;
    }

    public static void retirar(double saldo, double cantidad) throws SaldoInsuficienteException {
        if(cantidad > saldo){
            throw new SaldoInsuficienteException();
        } else {
            saldo -= cantidad;
        }
    }
}

