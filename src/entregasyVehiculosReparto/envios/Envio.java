package entregasyVehiculosReparto.envios;

import entregasyVehiculosReparto.model.Vehiculo;

public abstract class Envio {
    final int COSTE_BASE = 5;
    final double COSTE_POR_KM = 0.10;
    final int COSTE_POR_PRIORIDAD = 10;
    String codigo;
    double distanciaKm;
    double pesoKg;
    String destino;

    public Envio(String codigo, double distanciaKm, double pesoKg, String destino) {
        this.codigo = codigo;
        this.distanciaKm = distanciaKm;
        this.pesoKg = pesoKg;
        this.destino = destino;
    }

    public final double calcularCostePorKg(){
        if(pesoKg <= 0) return 0;
        if(pesoKg < 10) return 3;

        if(pesoKg >= 10 && pesoKg <= 25) return 5;
        if(pesoKg > 25) return 10;


        return 0;
    }

    public abstract double calcularCoste();

    public boolean esValidoPara(Vehiculo v){
        return true;
    }



    public boolean equals(Object o){
        if (o instanceof Envio){
            Envio e = (Envio) o;
            return this.codigo.equals(e.codigo);
        }
        return false;
    }

    public String getCodigo(){
        return this.codigo;
    }

     public String toString(){
         return "Envio " + codigo + " a " + destino + " de " + pesoKg + " kg y " + distanciaKm + " km";
     }

     public double getPesoKg(){
        return this.pesoKg;
     }


}
