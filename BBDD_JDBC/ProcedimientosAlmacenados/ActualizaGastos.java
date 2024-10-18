package BBDD_JDBC.ProcedimientosAlmacenados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ActualizaGastos {
    /*PROCEDIMIENTO ALMACENADO EN MYSQL
     * CREATE PROCEDURE ACTUALIZA_GASTO(N_PRECIO INT, NOMBRE_GASTO VARCHAR(25)) 
     * UPDATE gastos SET valor = N_PRECIO WHERE nombre = NOMBRE_GASTO;
    */
    public static void main(String[] args) {
        
        int valorGasto = Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor"));

        String nombreGasto = JOptionPane.showInputDialog("Introduce el nombre del artículo");

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

            CallableStatement miSentencia = miConexion.prepareCall("{call ACTUALIZA_GASTO(?, ?)}");

            miSentencia.setInt(1, valorGasto);
            miSentencia.setString(2, nombreGasto);
            if(!miSentencia.execute()){ /*execute() - Devuelve:
                true si el primer resultado es un objeto; Si el primer resultado es una actualización recuento o no hay resultado ResultSet false */
                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
