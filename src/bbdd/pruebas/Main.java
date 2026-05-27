package bbdd.pruebas;

import bbdd.pruebas.model.Producto;
import bbdd.pruebas.model.ProductoDAO;

public class Main {
    static void main(String[] args) {
        ProductoDAO pDAO = new ProductoDAO();

        Producto p1 = new Producto("cafe",5,1.99);
        pDAO.insertarAlumno(p1);
    }
}
