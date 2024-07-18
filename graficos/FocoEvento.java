package graficos;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FocoEvento {
    public static void main(String[] args) {
        MarcoFoco miMarco = new MarcoFoco();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoFoco extends JFrame{
    public MarcoFoco(){
        setVisible(true);
        setBounds(300, 300, 600, 450);
        add(new LaminaFoco());
    }
}

class LaminaFoco extends JPanel{

    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        //Invalidar el layout, osea no hay colocación de los elementos por defecto
        setLayout(null);

        cuadro1 = new JTextField();
        cuadro2 = new JTextField();

        cuadro1.setBounds(120, 10, 150, 20);
        cuadro2.setBounds(120, 50, 150, 20);

        add(cuadro1);
        add(cuadro2);

        //LanzaFocos elFoco = new LanzaFocos();
        cuadro1.addFocusListener(new LanzaFocos());
    }

    private class LanzaFocos implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            // TODO Auto-generated method stub
            
        }
    
        @Override
        public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
            //System.out.println("He perdido el foco");
            String email = cuadro1.getText();
            boolean comprobacion = false;

            for(int i = 0; i < email.length(); i++){
                if(email.charAt(i) == '@'){
                    comprobacion = true;
                }
            }

            if(comprobacion){
                System.out.println("Es correcto");
            }else{
                System.out.println("El email no es válido");
            }
        }
        
    }

    JTextField cuadro1, cuadro2;
    
}