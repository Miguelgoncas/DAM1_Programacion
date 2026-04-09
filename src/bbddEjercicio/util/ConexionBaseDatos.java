package bbddEjercicio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    /* Creo la conexión a la base de datos como clase
    para poder usarla
     */

    // Creamos final para que no se puedan modificar
    // Url de conexión
    private static final String url = "jdbc:mysql://localhost:3306/tienda";

    // Usuario y contraseña
    private static final String user = "root";
    private static final String password ="1234";


    // Creamos metodo para la conexión

    public static Connection getConnection(){
        // Agrego driver de conexión
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
