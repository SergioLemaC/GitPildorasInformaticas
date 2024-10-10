package BBDD_JDCB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaUsuarios {
    public static void main(String[] args) {
        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "Sergio011304*");

            Statement miStatement = miConexion.createStatement();

            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM usuarios");

            while(miResultSet.next()){
                System.out.println(miResultSet.getString("cedula") + " | " + miResultSet.getString("nombre") + " | " + miResultSet.getString("apellido"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
