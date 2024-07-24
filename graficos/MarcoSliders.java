package graficos;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
//import javax.swing.SwingConstants;

public class MarcoSliders {
    public static void main(String[] args) {
        FrameSliders miMarco = new FrameSliders();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class FrameSliders extends JFrame{
    public FrameSliders(){
        setBounds(550, 400, 550, 350);

        LaminaSliders miLamina = new LaminaSliders();

        add(miLamina);

        setVisible(true);
    }
}

class LaminaSliders extends JPanel{
    public LaminaSliders(){
        JSlider control = new JSlider(/*SwingConstants.VERTICAL,*/0,100,50);
        //control.setOrientation(SwingConstants.VERTICAL);
        control.setMajorTickSpacing(50);
        control.setMinorTickSpacing(25);
        control.setPaintTicks(true);
        control.setFont(new Font("Serif", Font.ITALIC, 12));
        control.setPaintLabels(true);
        control.setSnapToTicks(true); //Para que se adapte a las marcas dando valores fijos
        add(control);
    }
}