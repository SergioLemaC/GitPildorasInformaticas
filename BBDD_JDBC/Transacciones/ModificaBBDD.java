package BBDD_JDBC.Transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModificaBBDD {
    public static void main(String[] args) {
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

            miConexion.setAutoCommit(false);

            Statement miStatement = miConexion.createStatement();

            String sql1 = "INSERT INTO usuarios (cedula, contraseña, nombre, apellido, email, telefono, cargo, pais) VALUES ('72177180', '1234', 'Ernesto', 'Fernández', 'e.soto71@gmail.com', '3003265115', 'Asesor Comercial', 'Colombia')";

            miStatement.executeUpdate(sql1);

            String sql2 = "INSERT INTO gastos (nombre, fecha, valor, descripcion, gasto_categoria, gasto_cedula) VALUES ('Salchitajá', '2024-10-20', '15000', 'Salida con los reales', 'Alimentación', '72177180')";

            miStatement.executeUpdate(sql2);

            miConexion.commit();

            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            try {
                miConexion.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
