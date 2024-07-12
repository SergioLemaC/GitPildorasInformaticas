package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDibujo {
    public static void main(String[] args) {
        MarcoConDibujos miMarco = new MarcoConDibujos();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoConDibujos extends JFrame{
    public MarcoConDibujos(){
        setTitle("Prueba de Dibujo");
        setSize(1000,1000);
        LaminaConFiguras miLamina = new LaminaConFiguras();
        add(miLamina);
        miLamina.setBackground(Color.DARK_GRAY);

        //Acá para que todos los objetos de ese tipo tengan las mismas propiedades
        //miLamina.setForeground(Color.BLUE);
    }
}

class LaminaConFiguras extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.drawRect(50, 50, 200, 200);
        //g.drawLine(100, 100, 300, 200);
        //g.drawArc(50, 100, 100, 200, 120, 150);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.setPaint(Color.RED);
        g2.fill(rectangulo);

        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        //Podemos colorear también instanciando una clase para los rgb
        g2.setPaint(new Color(0,140,255).brighter().brighter().brighter());
        //Una forma de colorear
        //g2.setPaint(Color.CYAN);
        //Draw para dibujar el contorno
        //g2.draw(elipse);
        //Fill para el relleno
        g2.fill(elipse);

        /*g2.draw(new Line2D.Double(100, 100, 300, 250));

        double centroEnX = rectangulo.getCenterX();
        double centroEnY = rectangulo.getCenterY();
        double radio = 150;
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroEnX, centroEnY, centroEnX+radio, centroEnY+radio);
        g2.draw(circulo);*/

        Font miFuente = new Font("Centaur", Font.BOLD, 26);
        g2.setFont(miFuente);
        g2.setColor(Color.WHITE);
        g2.drawString("Sergio Lema", 50, 50);
        g2.setFont(new Font("Arial", Font.ITALIC, 24));
        g2.setColor(new Color(128,90,50).brighter());
        g2.drawString("Curso de Java", 100, 200);

        try {
            imagen = ImageIO.read(new File("graficos/IMG-20200120-WA0002.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("La imagen no se encuentra");
        }

        g.drawImage(imagen, 200, 200, null);
    }
    private Image imagen;

}