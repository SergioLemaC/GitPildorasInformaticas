package graficos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MarcoMenu {
    public static void main(String[] args) {
        MenuFrame miMarco = new MenuFrame();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MenuFrame extends JFrame{
    public MenuFrame(){
        setBounds(500, 300, 550, 400);

        MenuLamina miLamina = new MenuLamina();
        add(miLamina);
        setVisible(true);
    }
}

class MenuLamina extends JPanel{
    public MenuLamina(){
        JMenuBar miBarra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edición");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu opciones = new JMenu("Opciones");

        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardarComo = new JMenuItem("Guardar Como");
        archivo.add(guardar);
        archivo.add(guardarComo);

        JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("graficos/netbeans.png"));
        JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("graficos/Maple.gif"));
        copiar.setHorizontalTextPosition(SwingConstants.LEFT); //Cambiar de posición el texto por la imagen del ícono
        JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("graficos/code_70x70.png"));
        edicion.add(cortar);
        edicion.add(copiar);
        edicion.add(pegar);
        edicion.addSeparator(); //Agregar una línea separadora

        JMenuItem generales = new JMenuItem("Generales");
        herramientas.add(generales);

        JMenuItem opcion1 = new JMenuItem("Opción 1");
        JMenuItem opcion2 = new JMenuItem("Opción 2");
        opciones.add(opcion1);
        opciones.add(opcion2);
        edicion.add(opciones); //Agregarlo a otro item de opciones

        miBarra.add(archivo);
        miBarra.add(edicion);
        miBarra.add(herramientas);

        add(miBarra);
    }
}