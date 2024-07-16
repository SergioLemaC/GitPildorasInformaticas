package graficos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class EventosTeclado {
    public static void main(String[] args) {
        MarcoConTeclas miMarco = new MarcoConTeclas();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConTeclas extends JFrame{
    public MarcoConTeclas(){
        setVisible(true);
        setBounds(700, 300, 600, 450);

        //EventoDeTeclado tecla = new EventoDeTeclado();
        addKeyListener(new EventoDeTeclado());
    }
}

class EventoDeTeclado implements KeyListener{

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getKeyChar());
    }
    
}