package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class DisposicionMuelle {
    public static void main(String[] args) {
        MarcoMuelle miMarco = new MarcoMuelle();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoMuelle extends JFrame{
    public MarcoMuelle(){
        setBounds(300, 400, 1000, 350);

        LaminaMuelle miLamina = new LaminaMuelle();
        add(miLamina);

        setVisible(true);
    }
}

class LaminaMuelle extends JPanel{
    public LaminaMuelle(){
        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");
        JButton boton3 = new JButton("Botón 3");

        SpringLayout miLayout = new SpringLayout();
        
        setLayout(miLayout);

        add(boton1);
        add(boton2);
        add(boton3);

        Spring miMuelle = Spring.constant(0, 10, 100);

        Spring muelleRigido = Spring.constant(80); //El argumento que recibe es la distancia o ancho que va a tener este muelle que es rígido
        
        miLayout.putConstraint(SpringLayout.WEST, boton1, miMuelle, SpringLayout.WEST, this);
        //                     Punto de partida, Oeste del boton2, pongo miMuelle, tiene que ir a la parte Este del boton1
        miLayout.putConstraint(SpringLayout.WEST, boton2, muelleRigido, SpringLayout.EAST, boton1);
        miLayout.putConstraint(SpringLayout.WEST, boton3, muelleRigido, SpringLayout.EAST, boton2);

        miLayout.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, boton3);
    }
}