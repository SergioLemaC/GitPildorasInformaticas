package MVC.controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import MVC.modelo.CargaMenus;
import MVC.vista.MarcoAplicacion;

public class ControladorCargaMenus extends WindowAdapter{

    public ControladorCargaMenus(MarcoAplicacion elMarco){
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

            while (obj.rs2.next()) {
                elMarco.paises.addItem(obj.rs2.getString(1));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
 
    CargaMenus obj = new CargaMenus();
    private MarcoAplicacion elMarco;
}
