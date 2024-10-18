package MVC.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection miConexion = null;

    public Conexion(){

    }

    public Connection dameConexion(){
        try {
            //MYSQL
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "Contraseña");

            //ORACLE
            //Primero desde la terminal hay que iniciar el servicio de Oracle "lsnrctl start"
            //miConexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "Contraseña");

            //SQLSERVER
            //ASUS
            //miConexion = DriverManager.getConnection("jdbc:sqlserver://SERGIO:1433;databaseName=elqsea;trustServerCertificate=true" ,"lemac1nside", "Contraseña");
            //PC
            //miConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-P70AUTP:1433;databaseName=elqsea;trustServerCertificate=true" ,"lemac1nside", "Contraseña");

            //POSTGRESQL
            //miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Contraseña");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return miConexion;
    }
}
