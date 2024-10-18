package MVC.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MVC.controlador.Conexion;

public class EjecutaConsultas {

    public EjecutaConsultas(){
        miConexion = new Conexion();
    }

    public ResultSet filtraBBDD(String cargo, String pais){

        Connection conecta = miConexion.dameConexion();

        rs = null;

        try{

            if(!cargo.equals("Todos") && pais.equals("Todos")){
                
                enviaConsultaCargo = conecta.prepareStatement(consultaCargo);
                enviaConsultaCargo.setString(1, cargo);
                
                rs = enviaConsultaCargo.executeQuery();
                
            }else if(cargo.equals("Todos") && !pais.equals("Todos")){

                enviaConsultaPais = conecta.prepareStatement(consultaPais);
                enviaConsultaPais.setString(1, pais);

                rs = enviaConsultaPais.executeQuery();

            }else if(!cargo.equals("Todos") && !pais.equals("Todos")){

                enviaConsultaAmbos = conecta.prepareStatement(consultaAmbos);
                enviaConsultaAmbos.setString(1, cargo);
                enviaConsultaAmbos.setString(2, pais);

                rs = enviaConsultaAmbos.executeQuery();

            }else if(cargo.equals("Todos") && pais.equals("Todos")){

                enviaConsultaTodos = conecta.prepareStatement(consultaTodos);

                rs = enviaConsultaTodos.executeQuery();

            }

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    private Conexion miConexion;
    private ResultSet rs;
    private PreparedStatement enviaConsultaCargo, enviaConsultaPais, enviaConsultaAmbos, enviaConsultaTodos;
    private final String consultaCargo = "SELECT CEDULA, NOMBRE, APELLIDO, EMAIL, TELEFONO FROM USUARIOS WHERE CARGO=?";
    private final String consultaPais = "SELECT CEDULA, NOMBRE, APELLIDO, EMAIL, TELEFONO FROM USUARIOS WHERE PAIS=?";
    private final String consultaAmbos = "SELECT CEDULA, NOMBRE, APELLIDO, EMAIL, TELEFONO FROM USUARIOS WHERE CARGO=? AND PAIS=?";
    private final String consultaTodos = "SELECT CEDULA, NOMBRE, APELLIDO, EMAIL, TELEFONO FROM USUARIOS";
}
