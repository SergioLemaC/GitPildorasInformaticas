package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts {
    public static void main(String[] args) {
        MarcoLayout marco = new MarcoLayout();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoLayout extends JFrame{
    public MarcoLayout(){
        setTitle("Prueba acciones");
        setBounds(600, 350, 600, 300);

        PanelLayout lamina = new PanelLayout();
        //FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
        //lamina.setLayout(disposicion);
        //lamina.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 100));
        add(lamina, BorderLayout.NORTH);

        PanelLayout2 lamina2 = new PanelLayout2();
        add(lamina2, BorderLayout.SOUTH);
    }
}

class PanelLayout extends JPanel{
    public PanelLayout(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        //setLayout(new BorderLayout(10, 10));
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
        /*add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Verde"), BorderLayout.EAST);
        add(new JButton("Negro")); //BorderLayout.CENTER*/
    }
}

class PanelLayout2 extends JPanel{
    public PanelLayout2(){
        setLayout(new BorderLayout());
        add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Verde"), BorderLayout.EAST);
        add(new JButton("Negro")); //BorderLayout.CENTER
    }
}