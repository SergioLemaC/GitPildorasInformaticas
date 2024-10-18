package MVC.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MVC.controlador.Conexion;

public class CargaSecciones {
    public CargaSecciones(){
        miConexion = new Conexion();
    }

    public String ejecutaConsultas(){
        Usuarios miUsuario = null;

        Connection accesoBBDD = miConexion.dameConexion();

        try {
            Statement cargos = accesoBBDD.createStatement();

            rs = cargos.executeQuery("SELECT DISTINCT CARGO FROM USUARIOS");

            while (rs.next()) {
                miUsuario = new Usuarios();
                miUsuario.setCargo(rs.getString(1));
                return miUsuario.getCargo();
            }
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return miUsuario.getCargo();
    }

    Conexion miConexion;
    public ResultSet rs;
}
