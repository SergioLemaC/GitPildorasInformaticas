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


    //ORGÍA DE ERRORES DICE JUAN DÍAZ AKSJKASJKAJKASJKAJKSAKJA
    /*public String ejecutaConsultas(){
        Usuarios miUsuario = null;

        Connection accesoBBDD = miConexion.dameConexion();

        try {
            Statement cargos = accesoBBDD.createStatement();

            rs = cargos.executeQuery("SELECT DISTINCT CARGO FROM USUARIOS");

            //while (rs.next()) {
                //rs.previous(); //Devuelve el cursor una posición hacia atrás
            miUsuario = new Usuarios();
            miUsuario.setCargo(rs.getString(1));
                //return miUsuario.getCargo();
            //}
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return miUsuario.getCargo();
    }*/
    public ResultSet ejecutaConsultas(){
        Connection accesoBBDD = miConexion.dameConexion();
        try {
            Statement cargos = accesoBBDD.createStatement();
            return rs = cargos.executeQuery("SELECT DISTINCT CARGO FROM USUARIOS");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    Conexion miConexion;
    public ResultSet rs;
}
