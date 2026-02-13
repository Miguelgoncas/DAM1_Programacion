package practica_Integral_Figuras.model;

import practica_Integral_Figuras.Service.Figura;

import java.util.ArrayList;

public class GestorFiguras {
    private ArrayList<Figura> figuras;

    public GestorFiguras(){
        figuras = new ArrayList<Figura>();
    }

    public boolean anadirFigura(Figura f){
         return figuras.add(f);
    }

    public boolean eliminarFigura(Figura f){
        return figuras.remove(f);
    }

    public void dibujarTodas(){
        for(Figura f : figuras){
            f.dibuja();
        }
    }
    public double areaTotal(){
        double total = 0;
        for(Figura f: figuras){
            total += f.area();
        }
        return total;
    }

    public void moverFiguras(){
        for(Figura f : figuras){
            f.borra();
            f.dibuja();
        }

    }

    @Override
    public String toString() {
        String to = "";
        for(Figura f : figuras){
            to += f.toString() + "\n";
        }
        return to;
    }
}
