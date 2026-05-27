package ficheros.bbddEjercicio;

import ficheros.bbddEjercicio.model.LecturaFichero;
import ficheros.bbddEjercicio.model.ProductoDAO;

public class MainConexionEjercicio {
    static void main(String[] args) {


        // Creamos el ProductoDAO para poder trabajar
        ProductoDAO proDao= new ProductoDAO();
        /*
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
            ArrayList<Producto> arrProd = new ArrayList<>(proDao.obtenerProductos());

            System.out.println(arrProd);
        }




        // Listamos producto por id
        int idListar = 3;
        if (proDao.obtenerProductoID(idListar) != null ){
            System.out.println("El producto deseado es: ");
            System.out.println(proDao.obtenerProductoID(idListar));
        } else {
            System.out.println("El producto no se ha encontrado");
        }


        // Actualizamos producto por id
        int idUpdate = 3;

        if(proDao.actualizarProducto(idUpdate,"Lagarto", 12.50,70) != 0) {
            System.out.println("El producto se ha cambiado correctamente");
            System.out.println("Productos afectados: " + proDao.actualizarProducto(idUpdate,"Lagarto", 12.50,70));
        } else {
            System.out.println("No se ha modificado ningún producto");
        }

        System.out.println();

        // Eliminamos producto por id

        int borrarId = 2;

        if (proDao.eliminarProducto(2) != 0) {
            System.out.println("Producto eliminado correctamente");
            System.out.println("Productos afectados con la id: "+ borrarId);

        } else {
            System.out.println("No se ha encontrado ningún producto con ese id");
        }


        */

        LecturaFichero lf = new LecturaFichero();
        lf.leerArchivo();

        // Introduzco elemento a la base de datos desde un fichero
        //System.out.println("Elementos agregados, filas afectadas: " + proDao.cargaficheroProductos());



    }
}
