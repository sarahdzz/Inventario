package clases;

import java.sql.*;

public class Conexion {
// conexion anuestra base de datoa locas

    public static Connection conectar() {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("ERROR EN LA CONEXION" + e);
        }
        return (null);
    }

}
