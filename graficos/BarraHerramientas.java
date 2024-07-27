package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class BarraHerramientas {
    public static void main(String[] args) {
        MarcoBarra miMarco = new MarcoBarra();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoBarra extends JFrame{
    public MarcoBarra(){
        setTitle("Marco con barra");
        setBounds(500, 300, 600, 450);
        lamina = new JPanel();
        add(lamina);

        Action accionAzul = new AccionColorH("Azul", new ImageIcon("graficos/code_70x70.png"), Color.BLUE);
        Action accionAmarillo = new AccionColorH("Amarillo", new ImageIcon("graficos/netbeans.png"), Color.YELLOW);
        Action accionRojo = new AccionColorH("Rojo", new ImageIcon("graficos/Maple.gif"), Color.RED);

        Action accionSalir = new AbstractAction("Salir", new ImageIcon("graficos/netbeans.png")) {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                System.exit(0);
            }
            
        };

        JMenu menu = new JMenu("Color");

        menu.add(accionAzul);
        menu.add(accionAmarillo);
        menu.add(accionRojo);

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(menu);

        setJMenuBar(barraMenu);

        JToolBar barra = new JToolBar();

        barra.add(accionAzul);
        barra.add(accionAmarillo);
        barra.add(accionRojo);

        barra.addSeparator();

        barra.add(accionSalir);

        add(barra, BorderLayout.NORTH);
    }

    private class AccionColorH extends AbstractAction{
        public AccionColorH(String nombre, Icon icono, Color c){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
            putValue("Color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            Color c = (Color) getValue("Color");

            lamina.setBackground(c);
        }

        
    }
    private JPanel lamina;
}