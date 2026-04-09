package bbddEjercicio;

import bbddEjercicio.model.Producto;
import bbddEjercicio.model.ProductoDAO;

import java.util.ArrayList;

public class MainConexionEjercicio {
    static void main(String[] args) {

        // Creamos el ProductoDAO para poder trabajar
        ProductoDAO proDao= new ProductoDAO();

        // Vamos a crear unos produtos para poder trabajar con ellos

        Producto prod1 = new Producto("Leche", 1.80, 200);
        Producto prod2 = new Producto("Papel", 0.80, 80);
        Producto prod3 = new Producto("Nutella", 2.50, 50);
        Producto prod4 = new Producto("Aceitunas", 1.20, 5000);

        // Agregamos productos a la base de datos

        int filas = proDao.insertarProducto(prod1);
        System.out.println("Del primer producto se han agregado " + filas + " filas");

        filas = proDao.insertarProducto(prod2);
        System.out.println("Del segundo producto se han agregado " + filas + " filas" );

        filas = proDao.insertarProducto(prod3);
        System.out.println("Del tercer producto se han agregado " + filas + " filas" );

        filas = proDao.insertarProducto(prod4);
        System.out.println("Del cuarto producto se han agregado " + filas + " filas" );


        // Listamos productos de la base de datos

        if (proDao.obtenerProductos().isEmpty()){
            System.out.println("No hay productos en la base de datos");
        } else {
            ArrayList<Producto> arrProd = new ArrayList<Producto>();
            arrProd.addAll(proDao.obtenerProductos());

            System.out.println(arrProd);
        }


        // Listamos producto por id
        int idListar = 2;
        if (proDao.obtenerProductoID(idListar) != null ){
            System.out.println("El producto deseado es: ");
            System.out.println(proDao.obtenerProductoID(idListar));
        } else {
            System.out.println("El producto no se ha encontrado");
        }


        // Actualizamos producto por id
        int idUpdate = 2;

        if(proDao.actualizarProducto(idUpdate) != 2) {
            System.out.println("El producto se ha cambiado correctamente");
            System.out.println("Productos afectados: " + proDao.actualizarProducto(idUpdate));
        } else {
            System.out.println("No se ha modificado ningún producto");
        }

    }
}
