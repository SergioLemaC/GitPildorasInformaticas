package MVC.controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import MVC.modelo.CargaSecciones;
import MVC.vista.MarcoAplicacion;

public class ControladorMuestraCargos extends WindowAdapter{

    public ControladorMuestraCargos(MarcoAplicacion elMarco){
        this.elMarco = elMarco;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        obj.ejecutaConsultas();

        try {
            while (obj.rs.next()) {
                elMarco.secciones.addItem(obj.rs.getString(1));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
 
    CargaSecciones obj = new CargaSecciones();
    private MarcoAplicacion elMarco;
}
