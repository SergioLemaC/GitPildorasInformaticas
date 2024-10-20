package BBDD_JDBC.MetaDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoMetaDatos {
    public static void main(String[] args) {
        //mostrarInfoBBDD();
        mostrarInfoTablas();
    }

    public static void mostrarInfoBBDD(){
        Connection miConexion = null;

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

            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            System.out.println("Gestor de BBDD: " + datosBBDD.getDatabaseProductName());

            System.out.println("Versión del gestor de BBDD: " + datosBBDD.getDatabaseProductVersion());

            System.out.println("Nombre del driver utilizado: " + datosBBDD.getDriverName());

            System.out.println("Versión del driver: " + datosBBDD.getDriverVersion());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                miConexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void mostrarInfoTablas(){
        Connection miConexion = null;
        ResultSet miResultSet = null;

        try{
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
        
            DatabaseMetaData datosBBDD = miConexion.getMetaData();
        
            /*System.out.println("Lista de tablas");
            miResultSet = datosBBDD.getTables(null, null, "u%", null);
            while (miResultSet.next()) {
                System.out.println(miResultSet.getString("TABLE_NAME"));
            }*/

            System.out.println("Descripción de las columnas de la tabla");
            miResultSet = datosBBDD.getColumns(null, null, "usuarios", null);
            while (miResultSet.next()) {
                System.out.println(miResultSet.getString("COLUMN_NAME"));
            }
        
            //System.out.println("Nombre del driver utilizado: ");
        
            //System.out.println("Versión del driver: ");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                try {
                    miConexion.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    }

}
