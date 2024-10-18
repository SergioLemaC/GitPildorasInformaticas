package MVC.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MVC.controlador.Conexion;

public class CargaMenus {
    public CargaMenus(){
        miConexion = new Conexion();
    }


    //ORGÍA DE ERRORES DICE JUAN DÍAZ AKSJKASJKAJKASJKAJKSAKJA
    public String ejecutaConsultas(){
        Usuarios miUsuario = null;

        Connection accesoBBDD = miConexion.dameConexion();

        try {
            Statement cargos = accesoBBDD.createStatement();
            Statement paises = accesoBBDD.createStatement();
            rs = cargos.executeQuery("SELECT DISTINCT CARGO FROM USUARIOS");
            rs2 = paises.executeQuery("SELECT DISTINCT PAIS FROM USUARIOS");
            //while (rs.next()) {
                //rs.previous(); //Devuelve el cursor una posición hacia atrás
                miUsuario = new Usuarios();
                miUsuario.setCargo(rs.getString(1));
                miUsuario.setPais(rs2.getString(1));
                //return miUsuario.getCargo();
            //}
            rs.close();
            rs2.close();
            accesoBBDD.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return miUsuario.getCargo();
    }
    /*public ResultSet ejecutaConsultas(){
        Connection accesoBBDD = miConexion.dameConexion();
        try {
            Statement cargos = accesoBBDD.createStatement();
            Statement paises = accesoBBDD.createStatement();
            rs = cargos.executeQuery("SELECT DISTINCT CARGO FROM USUARIOS");
            rs2 = paises.executeQuery("SELECT DISTINCT PAIS FROM USUARIOS");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }*/

    Conexion miConexion;
    public ResultSet rs, rs2;
}
