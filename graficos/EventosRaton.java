package graficos;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class EventosRaton {
    public static void main(String[] args) {
        MarcoRaton miMarco = new MarcoRaton();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoRaton extends JFrame{
    public MarcoRaton(){
        setVisible(true);
        setBounds(700, 300, 600, 450);

        //EventosDeRaton eventoRaton = new EventosDeRaton();
        addMouseMotionListener(new EventosDeRaton());
    }
}

class EventosDeRaton extends MouseAdapter /*implements MouseMotionListener*/{
    public void mouseClicked(MouseEvent e){
        System.out.println("Haz hecho click");
        System.out.println("Coordenada X: " + e.getX() + "\n" +
        "Coordenada Y: " + e.getY());
        System.out.println(e.getClickCount());

    }

    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("Acabas de presionar");
        //System.out.println(e.getModifiersEx());
        if(e.getModifiersEx() == InputEvent/*MouseEvent*/.BUTTON1_DOWN_MASK){
            System.out.println("Haz pulsado el click izquierdo");
        }else if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK){
            System.out.println("Haz pulsado la rueda del ratón");
        }else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK){
            System.out.println("Has pulsado el click derecho");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Estás arrastrando");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Estás moviendo el ratón");
    }

    
}

/*class EventosDeRaton implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Haz hecho click");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Acabas de entrar");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Acabas de salir");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Acabas de presionar");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Acabas de levantar");
    }
    
}*/