package ProgramacionConcurrente;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsoThreads {
    public static void main(String[] args) {
        JFrame marco = new MarcoRebote();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class Pelota{
    public void muevePelota(Rectangle2D limites){
        x+=dx;
        y+=dy;

        if(x<limites.getMinX()){
            x = limites.getMinX();
            dx = -dx;
        }

        if(x + TAMX >= limites.getMaxX()){
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }

        if(y < limites.getMinY()){
            y = limites.getMinY();
            dy = -dy;
        }

        if(y + TAMY >= limites.getMaxY()){
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }
    }

    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
}

class LaminaPelota extends JPanel{
    public void add(Pelota b){
        pelotas.add(b);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for(Pelota b : pelotas){
            g2.fill(b.getShape());
        }
    }

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

class MarcoRebote extends JFrame{
    public MarcoRebote(){
        setBounds(600, 300, 600, 350);
        setTitle("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();

        arranca1 = new JButton("Hilo 1");
        arranca1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                comienzaElJuego(evento);
            }
        });
        laminaBotones.add(arranca1);

        arranca2 = new JButton("Hilo 2");
        arranca2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                comienzaElJuego(evento);
            }
        });
        laminaBotones.add(arranca2);

        arranca3 = new JButton("Hilo 3");
        arranca3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                comienzaElJuego(evento);
            }
        });
        laminaBotones.add(arranca3);

        detener1 = new JButton("Detener 1");
        detener1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                detener(evento);
            }
        });
        laminaBotones.add(detener1);

        detener2 = new JButton("Detener 2");
        detener2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                detener(evento);
            }
        });
        laminaBotones.add(detener2);

        detener3 = new JButton("Detener 3");
        detener3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                detener(evento);
            }
        });
        laminaBotones.add(detener3);

        /*ponerBoton(laminaBotones, "Dale!", new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                comienzaElJuego();
            }
        });

        ponerBoton(laminaBotones, "Salir", new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                System.exit(0);
            }
        });

        ponerBoton(laminaBotones, "Detener", new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                detener();
            }
        });*/

        add(laminaBotones, BorderLayout.SOUTH);
    }

    /*public void ponerBoton(Container c, String titulo, ActionListener oyente){
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }*/

    public void comienzaElJuego(ActionEvent e){
        Pelota pelota = new Pelota();
        lamina.add(pelota);

        Runnable r = new PelotaHilos(pelota, lamina);

        if(e.getSource().equals(arranca1)){
            t1 = new Thread(r);
            t1.start();
        }else if(e.getSource().equals(arranca2)){
            t2 = new Thread(r);
            t2.start();
        }else if(e.getSource().equals(arranca2)){
            t3 = new Thread(r);
            t3.start();
        }

        
    }

    public void detener(ActionEvent e){
        //t.stop();

        if(e.getSource().equals(detener1)){
            t1.interrupt();
        }else if(e.getSource().equals(detener2)){
            t2.interrupt();
        }else if(e.getSource().equals(detener3)){
            t3.interrupt();
        }
        
    }

    Thread t1, t2, t3;
    JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;
    private LaminaPelota lamina;

}

class PelotaHilos implements Runnable{

    public PelotaHilos(Pelota unaPelota, Component componente){
        this.pelota = unaPelota;
        this.componente = componente;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
        //for(int i = 1; i <= 3000; i++){
        //while(!Thread.interrupted()){
        while(!Thread.currentThread().isInterrupted()){
            pelota.muevePelota(componente.getBounds());
            componente.paint(componente.getGraphics());

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        //}
        //}

        System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());
        //throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
    private Pelota pelota;
    private Component componente;

}