package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

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
        addMouseListener(new EventosDeRaton());
    }
}

class EventosDeRaton extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
        System.out.println("Haz hecho click");
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