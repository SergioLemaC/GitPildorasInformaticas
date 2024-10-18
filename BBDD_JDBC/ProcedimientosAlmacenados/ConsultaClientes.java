package BBDD_JDBC.ProcedimientosAlmacenados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaClientes {

    /*PROCEDIMIENTO ALMACENADO EN MYSQL
     * CREATE PROCEDURE MUESTRA_CLIENTES() 
     * SELECT * FROM usuarios WHERE pais = 'Colombia'
     */
    public static void main(String[] args) {
        try {
            //MYSQL
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "Contraseña");

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

            CallableStatement miSentencia = miConexion.prepareCall("{call MUESTRA_CLIENTES}"); //Como no recibe parámetros no se colocan los paréntesis {call MUESTRA_CLIENTES()}

            ResultSet rs = miSentencia.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }

            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
