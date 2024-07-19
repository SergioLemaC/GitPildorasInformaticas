package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PruebaAcciones {
    public static void main(String[] args) {
        MarcoAccion marco = new MarcoAccion();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoAccion extends JFrame{
    public MarcoAccion(){
        setTitle("Prueba Acciones");
        setBounds(600, 350, 600, 300);

        PanelAccion lamina = new PanelAccion();
        add(lamina);
    }
}

class PanelAccion extends JPanel{
    public PanelAccion(){

        AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("graficos/netbeans.png"), Color.YELLOW);
        AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("graficos/code_70x70.png"), Color.BLUE);
        AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("graficos/Maple.gif"), Color.RED);

        add(new JButton(accionAmarillo));
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));

        /*JButton botonAmarillo = new JButton(accionAmarillo);
        add(botonAmarillo);

        JButton botonAmarillo = new JButton("Amarillo");
        JButton botonAzul = new JButton("Azul");
        JButton botonRojo = new JButton("Rojo");
        add(botonAmarillo);
        add(botonAzul);
        add(botonRojo);*/

        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); //Indicamos que el objeto que va a recibir el foco que es el botón, pues está dentro de la ventana del foco
        //Y también podemos usar WHEN_ANCESTOR_OF_FOCUSED_COMPONENT que es bastante similar

        //Crear combinación de teclas
        // --------->KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");

        //Agrega un vínculo entre la combinación de teclas y la acción
        mapaEntrada.put(/*teclaAmarillo*/ KeyStroke.getKeyStroke("ctrl A"), "fondoAmarillo");
        mapaEntrada.put(/*teclaAmarillo*/ KeyStroke.getKeyStroke("ctrl T"), "fondoAmarillo"); //Por si quieres asignar más teclas
        mapaEntrada.put(/*teclaAzul*/ KeyStroke.getKeyStroke("ctrl B"), "fondoAzul");
        mapaEntrada.put(/*teclaRojo*/ KeyStroke.getKeyStroke("ctrl R"), "fondoRojo");

        //Crear un mapa de acción para luego utilizar el método put perteneciente a la clase ActionMap y poder asignar o crear
        //un vínculo entre el objeto creado anteriormente (fondoAmarillo) con la acción ya en sí misma
        ActionMap mapaAccion = getActionMap(); //Devuelve un objeto de tipo ActionMap utilizado para determinar qué acción de desencadena
        //para una particular combinación de teclas

        //Asignamos ese objeto a la combinación de teclas
        mapaAccion.put("fondoAmarillo", accionAmarillo);
        mapaAccion.put("fondoAzul", accionAzul);
        mapaAccion.put("fondoRojo", accionRojo);
    }

    private class AccionColor extends AbstractAction{

        public AccionColor(String nombre, Icon icono, Color colorBoton){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color: " + nombre);
            putValue("color_de_fondo", colorBoton);
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color)getValue("color_de_fondo");
            setBackground(c);

            System.out.println("Nombre: " + getValue(Action.NAME));
            System.out.println("Descripción: " + getValue(Action.SHORT_DESCRIPTION));
        }
        
    }
}