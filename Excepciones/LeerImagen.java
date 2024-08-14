package Excepciones;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class LeerImagen {
    public static void main(String[] args) {
        MarcoImagen miMarco = new MarcoImagen();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoImagen extends JFrame{
    public MarcoImagen(){
        setTitle("Marco con imagen");

        setBounds(750, 300, 300, 200);

        LaminaConImagen miLamina = new LaminaConImagen();
        add(miLamina);
    }
}

class LaminaConImagen extends JPanel{
    public LaminaConImagen(){
        try {
            imagen = ImageIO.read(new File("graficos/goku32.jpg"));
        } catch (IOException e) {
            System.out.println("La imagen no se encuentra");
        }
    }

    public void paintComponent(Graphics g) throws NullPointerException{
        super.paintComponent(g);

        //if(imagen == null){
            //g.drawString("La imagen no está disponible", 10, 10);
        //}else{

        try{

            int anchuraImagen = imagen.getWidth(this);

            int alturaImagen = imagen.getHeight(this);

            g.drawImage(imagen, 0, 0, null);

            for(int i = 0; i < 300; i++){
                for(int j = 0; j < 200; j++){
                    if(i + j > 0){
                        g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen * i, alturaImagen * j);
                    }
                }
            }
        }catch(NullPointerException e){
            g.drawString("No se ha podido cargar la imagen", 10, 10);
        }
        //}
    }
    private Image imagen;
}