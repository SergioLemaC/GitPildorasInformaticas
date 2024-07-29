package graficos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class LibreDisposicion {
    public static void main(String[] args) {
        MarcoLibre miMarco = new MarcoLibre();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoLibre extends JFrame{
    public MarcoLibre(){
        setBounds(450,350,600,400);

        LaminaLibre miLamina = new LaminaLibre();
        add(miLamina);

        setVisible(true);
    }
}

class LaminaLibre extends JPanel{
    public LaminaLibre(){
        setLayout(new EnColumnas());

        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");

        JTextField cNombre = new JTextField();
        JTextField cApellido = new JTextField();

        add(nombre);
        add(cNombre);
        add(apellido);
        add(cApellido);
    }
}

class EnColumnas implements LayoutManager{

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void layoutContainer(Container parent) {
        // TODO Auto-generated method stub
        
        int contador = 0;
        int n = parent.getComponentCount();

        for(int i = 0; i < n; i++){
            contador++;

            Component c = parent.getComponent(i);

            c.setBounds(x, y, 100, 20);

            x += 100;

            if(contador % 2 == 0){
                x = 20;
                y += 40;
            }
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // TODO Auto-generated method stub
        
    }

    private int x = 20;
    private int y = 20;
    
}