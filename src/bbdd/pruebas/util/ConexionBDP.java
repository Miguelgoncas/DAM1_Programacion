package bbdd.pruebas.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDP {

    // Conexión con base de datos

    private static final String URL = "jdbc:mysql://localhost:3306/programacion";

    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // He agregado el Driver al proyecto porque sino da error, mysql Connection
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}

