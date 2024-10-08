package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PruebaSliders {
    public static void main(String[] args) {
        FrameSlider miMarco = new FrameSlider();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class FrameSlider extends JFrame{
    public FrameSlider(){
        setBounds(550, 400, 550, 350);

        LaminaSlider miLamina = new LaminaSlider();
        add(miLamina);
        setVisible(true);
    }
}

class LaminaSlider extends JPanel{
    public LaminaSlider(){
        setLayout(new BorderLayout());

        rotulo = new JLabel("En un lugar de la mancha de cuyo nombre...");
        add(rotulo, BorderLayout.CENTER);

        control = new JSlider(8, 50, 12);
        control.setMajorTickSpacing(20);
        control.setMinorTickSpacing(5);
        control.setPaintTicks(true);
        control.setPaintLabels(true);
        control.setFont(new Font("Serif", Font.ITALIC, 10));

        control.addChangeListener(new EventoSlider());

        JPanel laminaSlider = new JPanel();
        laminaSlider.add(control);

        add(laminaSlider, BorderLayout.NORTH);
    }

    private class EventoSlider implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            // TODO Auto-generated method stub
            
            rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
        }
        
    }

    private JLabel rotulo;
    private JSlider control;
}