package Applets;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HolaAlumnos extends JApplet{
    //No hay método main, sino init()
    public void init(){
        JLabel rotulo = new JLabel("Hola alumno", SwingConstants.CENTER);
        add(rotulo);
    }
}
