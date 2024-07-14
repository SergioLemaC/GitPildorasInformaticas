package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaEventos {
    public static void main(String[] args) {
        MarcoConBotones miMarco = new MarcoConBotones();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConBotones extends JFrame{
    public MarcoConBotones(){
        setTitle("Botones y eventos");
        setSize(1000,1000);
        LaminaBotones miLamina = new LaminaBotones();
        add(miLamina);

        //Acá para que todos los objetos de ese tipo tengan las mismas propiedades
        //miLamina.setForeground(Color.BLUE);
    }
}

class LaminaBotones extends JPanel implements ActionListener{
    //Creamos el botón
    JButton botonNegro = new JButton("Negro");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");
    
    public LaminaBotones(){
        add(botonNegro);
        add(botonAmarillo);
        add(botonRojo);
        //El botón va a desencadenar un evento de tipo clic
        //y el objeto que tiene que estar a la escucha es this, osea la propia clase
        //Declaramos 3 objetos fuente
        botonNegro.addActionListener(this); //Al hacer clic
        botonRojo.addActionListener(this);
        botonAmarillo.addActionListener(this);
    }

    //Obligatoriamente debemos construir la función actionPerformed() ya que la clase 
    //implementa la interfaz ActionListener
    public void actionPerformed(ActionEvent e){ //Después de que tenga lugar ese evento, se crearán objetos de tipo event y se almacenarán en la (e)
        //getSource() permite capturar el origen del evento
        Object botonPulsado = e.getSource();
        if(botonPulsado==botonNegro){
            setBackground(Color.BLACK);
        }else if(botonPulsado==botonAmarillo){
            setBackground(Color.YELLOW);
        }else{
            setBackground(Color.RED);
        }
        
    }

    /*Lo que ocurre es que cuando le damos clic al botón
     * Java construye un objeto de tipo evento y ese objeto
     * automáticamente viaja al objeto de tipo ActionEvent 
     * de la función actionPerformed() y se ejecuta esa función
     */
}