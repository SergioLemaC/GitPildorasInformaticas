package graficos;

import java.awt.Dimension;
//import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
//import javax.swing.SpinnerDateModel;
//import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class MarcoSpinner {
    public static void main(String[] args) {
        FrameSpinner miMarco = new FrameSpinner();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class FrameSpinner extends JFrame{
    public FrameSpinner(){
        setBounds(550, 350, 550, 350);
        setVisible(true);
        add(new LaminaSpinner());
    }
}

class LaminaSpinner extends JPanel{
    public LaminaSpinner(){

        //String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        JSpinner control = new JSpinner(/*new MiModeloJSpinner()//new SpinnerListModel(lista)*/ new SpinnerNumberModel(5,0,10,1){
            //CLASE INTERNA ANÓNIMA
            @Override
            public Object getNextValue() {
                // TODO Auto-generated method stub
                return super.getPreviousValue();
            }
    
            @Override
            public Object getPreviousValue() {
                // TODO Auto-generated method stub
                return super.getNextValue();
            }
        });

        Dimension d = new Dimension(100, 20);
        control.setPreferredSize(d);

        add(control);
    }
    /*private class MiModeloJSpinner extends SpinnerNumberModel{
        public MiModeloJSpinner(){
            super(5, 0, 10, 1);
        }

        @Override
        public Object getNextValue() {
            // TODO Auto-generated method stub
            return super.getPreviousValue();
        }

        @Override
        public Object getPreviousValue() {
            // TODO Auto-generated method stub
            return super.getNextValue();
        }

        
        
    }*/
}