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
            //Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "Contraseña");

            //ORACLE
            //Primero desde la terminal hay que iniciar el servicio de Oracle "lsnrctl start"
            //Connection miConexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "Contraseña");

            //SQLSERVER
            //Connection miConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-P70AUTP:1433;databaseName=elqsea;trustServerCertificate=true" ,"lemac1nside", "Contraseña");

            //POSTGRESQL
            Connection miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Contraseña");

            Statement miStatement = miConexion.createStatement();

            //Insertar, eliminar o actualizar datos con otra función para no devolver un objeto ResultSet
            //                      INSERT, UPDATE O DELETE
            String instruccionSQL = "INSERT INTO USUARIOS (CEDULA, CONTRASEÑA, NOMBRE, APELLIDO, EMAIL, TELEFONO, CARGO, PAIS) VALUES ('dato', 'dato', 'dato', 'dato', 'dato@dato.com', 'dato', 'dato', 'dato')";
            miStatement.executeUpdate(instruccionSQL);

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
