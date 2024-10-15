package BBDD_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasPreparada {
    public static void main(String[] args) {
        try {
            //MYSQL
            //Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "Contraseña");

            //ORACLE
            //Primero desde la terminal hay que iniciar el servicio de Oracle "lsnrctl start"
            //Connection miConexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "Contraseña");

            //SQLSERVER
            //Connection miConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-P70AUTP:1433;databaseName=elqsea;trustServerCertificate=true" ,"lemac1nside", "Contraseña");

            //POSTGRESQL
            Connection miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Contraseña");

            PreparedStatement miStatement = miConexion.prepareStatement("SELECT * FROM USUARIOS WHERE CARGO=? AND PAIS=?");

            miStatement.setString(1, "Ingeniero de Software");
            miStatement.setString(2, "Colombia");

            ResultSet miResultSet = miStatement.executeQuery();

            while(miResultSet.next()){
                System.out.println(miResultSet.getString("CEDULA") + " | " + miResultSet.getString("NOMBRE") + " | " + miResultSet.getString("APELLIDO"));
            }

            miResultSet.close();

            //Reutilizar consulta SQL -----------------------------------------------------------------
            System.out.println("");

            miStatement.setString(1, "Ama de casa");
            miStatement.setString(2, "Colombia");

            miResultSet = miStatement.executeQuery();

            while(miResultSet.next()){
                System.out.println(miResultSet.getString("CEDULA") + " | " + miResultSet.getString("NOMBRE") + " | " + miResultSet.getString("APELLIDO"));
            }

            miResultSet.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

            
    }
}
