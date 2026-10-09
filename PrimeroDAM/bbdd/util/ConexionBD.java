package bbdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Conexión con base de datos
    // Se necesita la URL USER y PASSWORD

    // jddc = java datebase conector

    // "driver:tipoBBDD://Local o IP y puerto, 3306: // Nombre

    // SI esta en nuetro ordenador, localhost, sino podemos IP

    private static final String URL = "jdbc:mysql://localhost:3306/programacion";

    // Usuario y contraseña nunca deberia estar aquí dentro del programa, debería estar en archivo externo,
    // por ejemplo xml
    private static final String USER = "root";
    private static final String PASSWORD = "1234";



    // Metodo de conexión con la base de datos
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // He agregado el Driver al proyecto porque sino da error, mysql Connection
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }



}
