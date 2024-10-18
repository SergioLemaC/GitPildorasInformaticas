package MVC.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import MVC.modelo.EjecutaConsultas;
import MVC.vista.MarcoAplicacion;

public class ControladorBotonEjecuta implements ActionListener{

    public ControladorBotonEjecuta(MarcoAplicacion elMarco){
        this.elMarco = elMarco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String seleccionCargo = (String)elMarco.secciones.getSelectedItem();
        String seleccionPais = (String)elMarco.paises.getSelectedItem();

        resultadoConsulta = obj.filtraBBDD(seleccionCargo, seleccionPais);

        try {

            elMarco.resultado.setText("");

            while (resultadoConsulta.next()) {
                elMarco.resultado.append(resultadoConsulta.getString(1));
                elMarco.resultado.append("|");
                elMarco.resultado.append(resultadoConsulta.getString(2));
                elMarco.resultado.append("|");
                elMarco.resultado.append(resultadoConsulta.getString(3));
                elMarco.resultado.append("|");
                elMarco.resultado.append(resultadoConsulta.getString(4));
                elMarco.resultado.append("|");
                elMarco.resultado.append(resultadoConsulta.getString(5));
                elMarco.resultado.append("\n");
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    private MarcoAplicacion elMarco;
    EjecutaConsultas obj = new EjecutaConsultas();
    private ResultSet resultadoConsulta;
}
