package practicas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MarcoDialogo extends JFrame{
    public MarcoDialogo(){
        setTitle("Prueba de diálogos");
        setBounds(500, 300, 600, 450);

        JPanel laminaCuadricula = new JPanel();
        laminaCuadricula.setLayout(new GridLayout(2,3));
        
        String primero[] = {
            "Mensaje", "Confirmar", "Opción", "Entrada"
        };

        laminaTipo = new LaminaBotones("Tipo", primero);

        laminaTipoMsj = new LaminaBotones("Tipo de mensaje", new String[]{
            "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"
        });

        laminaMsj = new LaminaBotones("Mensaje", new String[]{
            "Cadena", "Icono", "Componente", "Otros", "Object[]"
        });

        laminaTipoOpcion = new LaminaBotones("Confirmar", new String[]{
            "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"
        });

        laminaOpciones = new LaminaBotones("Opción", new String[]{
            "String[]", "Icon[]", "Object[]"
        });

        laminaEntrada = new LaminaBotones("Entrada", new String[]{
            "Campo de texto", "Combo"
        });

        setLayout(new BorderLayout());

        laminaCuadricula.add(laminaTipo);
        laminaCuadricula.add(laminaTipoMsj);
        laminaCuadricula.add(laminaMsj);
        laminaCuadricula.add(laminaTipoOpcion);
        laminaCuadricula.add(laminaOpciones);
        laminaCuadricula.add(laminaEntrada);

        //Construímos la lámina inferior

        JPanel laminaMostrar = new JPanel();

        JButton botonMostrar = new JButton("Mostrar");

        botonMostrar.addActionListener(new AccionMostrar());

        laminaMostrar.add(botonMostrar);

        add(laminaMostrar, BorderLayout.SOUTH);
        add(laminaCuadricula, BorderLayout.CENTER);
    }

    public Object dameMensaje(){
        String s = laminaMsj.dameSeleccion();

        if(s.equals("Cadena")){
            return cadenaMsj;
        }else if(s.equals("Icono")){
            return iconoMsj;
        }else if(s.equals("Componente")){
            return componenteMsj;
        }else if(s.equals("Otros")){
            return objetoMsj;
        }else if(s.equals("Object[]")){
            return new Object[]{
                cadenaMsj, iconoMsj, componenteMsj, objetoMsj
            };
        }else{
            return null;
        }
    }

    public int dameTipo(LaminaBotones lamina){
        String s = lamina.dameSeleccion();

        if(s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")){
            return 0;
        }else if(s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")){
            return 1;
        }else if(s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")){
            return 2;
        }else if(s.equals("QUESTION_MESSAGE")){
            return 3;
        }else if(s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")){
            return -1;
        }else{
            return 0;
        }
    }

    public Object[] dameOpciones(LaminaBotones lamina){
        String s = lamina.dameSeleccion();

        if(s.equals("String[]")){
            return new String[]{
                "Amarillo", "Azul", "Rojo"
            };
        }else if(s.equals("Icon[]")){
            return new Object[]{
                new ImageIcon("graficos/ryu32.jpg"),
                new ImageIcon("graficos/ryured.gif"),
                new ImageIcon("graficos/goku32.jpg")
            };
        }else if(s.equals("Object[]")){
            return new Object[]{
                cadenaMsj, iconoMsj, componenteMsj, objetoMsj
            };
        }else{
            return null;
        }
    }

    private class AccionMostrar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            //System.out.println(laminaTipo.dameSeleccion());

            if(laminaTipo.dameSeleccion().equals("Mensaje")){
                JOptionPane.showMessageDialog(MarcoDialogo.this, dameMensaje(), "Título", dameTipo(laminaTipoMsj));
            }else if(laminaTipo.dameSeleccion().equals("Confirmar")){
                JOptionPane.showConfirmDialog(MarcoDialogo.this, dameMensaje(), "Título", dameTipo(laminaTipoOpcion), dameTipo(laminaTipoMsj));
            }else if(laminaTipo.dameSeleccion().equals("Entrada")){
                if(laminaEntrada.dameSeleccion().equals("Campo de texto")){
                    JOptionPane.showInputDialog(MarcoDialogo.this, dameMensaje(), "Título", dameTipo(laminaTipoMsj));
                }else{
                    JOptionPane.showInputDialog(MarcoDialogo.this, dameMensaje(), "Título", dameTipo(laminaTipoMsj), null, new String[]{"Amarillo" , "Azul", "Rojo"}, "Azul");
                }
            }else if(laminaTipo.dameSeleccion().equals("Opción")){
                JOptionPane.showOptionDialog(MarcoDialogo.this, dameMensaje(), "Título", 1, dameTipo(laminaTipoMsj), null, dameOpciones(laminaOpciones), null);
            }
        }
        
    }

    private LaminaBotones laminaTipo, laminaTipoMsj, laminaMsj, laminaTipoOpcion, laminaOpciones, laminaEntrada;
    private String cadenaMsj = "Mensaje";
    private Icon iconoMsj = new ImageIcon("graficos/ryured.gif");
    private Object objetoMsj = new Date();
    private Component componenteMsj = new LaminaEjemplo();
}

class LaminaEjemplo extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        g2.setPaint(Color.YELLOW);
        g2.fill(rectangulo);
    }
}