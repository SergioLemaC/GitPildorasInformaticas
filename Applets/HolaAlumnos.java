package Applets;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class HolaAlumnos extends JApplet{
    //No hay método main, sino init()
    public void init(){
        JLabel rotulo = new JLabel("Hola alumno");
        add(rotulo);
    }
}
