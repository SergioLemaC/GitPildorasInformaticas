package BBDD_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaUsuarios {
    public static void main(String[] args) {
        try {
            //MYSQL
            //Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "Sergio011304*");

            //ORACLE
            //Primero desde la terminal hay que iniciar el servicio de Oracle "lsnrctl start"
            //Connection miConexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "Sergio011304*");

            //SQLSERVER
            //Connection miConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-P70AUTP:1433;databaseName=elqsea;trustServerCertificate=true" ,"lemac1nside", "Sergio011304*");

            //POSTGRESQL
            Connection miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sergio011304*");

            Statement miStatement = miConexion.createStatement();

            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM USUARIOS");

            while(miResultSet.next()){
                System.out.println(miResultSet.getString("CEDULA") + " | " + miResultSet.getString("NOMBRE") + " | " + miResultSet.getString("APELLIDO"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
