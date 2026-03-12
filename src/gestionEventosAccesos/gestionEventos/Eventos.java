package gestionEventosAccesos.gestionEventos;

public abstract class Eventos {
    String codigo;
    String nombre;
    String fecha;
    double precioBase;
    int aforoMaximo;
    int inscritos;

    public Eventos(String codigo, String nombre, String fecha, double precioBase, int aforoMaximo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.precioBase = precioBase;
        this.aforoMaximo = aforoMaximo;
        this.inscritos = 0;
    }

    public abstract double calcularPrecioFinal();


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Eventos ev = (Eventos) o;

        return codigo.equals(ev.codigo);
    }

    @Override
    public String toString() {
        return "Eventos " +
                "codigo" + codigo + ' ' +
                ", nombre" + nombre + ' ' +
                ", fecha" + fecha + ' ' +
                ", precioBase" + precioBase +
                ", aforoMaximo" + aforoMaximo;
    }

    public boolean isCompleto(){
        return inscritos >= aforoMaximo;
    }

    public void incrementarInscritos(){
        inscritos++;
    }

    public String getCodigo(){
        return codigo;
    }


}
