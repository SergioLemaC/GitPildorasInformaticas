package graficos;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class Procesador_PuraPractica {
    public static void main(String[] args) {
        MenuProcesador miMarco = new MenuProcesador();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MenuProcesador extends JFrame{
    public MenuProcesador(){
        setBounds(500, 300, 550, 400);

        LaminaProcesador miLamina = new LaminaProcesador();
        add(miLamina);
        setVisible(true);
    }
}

class LaminaProcesador extends JPanel{
    public LaminaProcesador(){
        setLayout(new BorderLayout());

        JPanel laminaMenu = new JPanel();

        JMenuBar miBarra = new JMenuBar();

        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamaño = new JMenu("Tamaño");

        configuraMenu("Arial", "fuente", "Arial", 9, 10);
        configuraMenu("Courier", "fuente", "Courier", 9, 10);
        configuraMenu("Verdana", "fuente", "Verdana", 9, 10);

        //configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
        //configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);

        JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("graficos/Maple.gif"));
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("graficos/code_70x70.png"));

        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());

        //CON TODO LO QUE CONSTRUIMOS ARRIBA PUES OBVIAREMOS UNA DE LAS CONDICIONALES DE LA FUNCIÓN -configuraMenu()-

        estilo.add(negrita);
        estilo.add(cursiva);

        /*configuraMenu("12", "tamaño", "", 9, 12);
        configuraMenu("16", "tamaño", "", 9, 16);
        configuraMenu("20", "tamaño", "", 9, 20);
        configuraMenu("24", "tamaño", "", 9, 24);*/

        ButtonGroup tamañoLetra = new ButtonGroup();

        JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");

        tamañoLetra.add(doce);
        tamañoLetra.add(dieciseis);
        tamañoLetra.add(veinte);
        tamañoLetra.add(veinticuatro);

        doce.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 12));
        dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 16));
        veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 20));
        veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 24));

        tamaño.add(doce);
        tamaño.add(dieciseis);
        tamaño.add(veinte);
        tamaño.add(veinticuatro);

        miBarra.add(fuente);
        miBarra.add(estilo);
        miBarra.add(tamaño);

        laminaMenu.add(miBarra);

        add(laminaMenu, BorderLayout.NORTH);

        miArea = new JTextPane();

        add(miArea, BorderLayout.CENTER);
    }

    public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam){
        JMenuItem elemMenu = new JMenuItem(rotulo);

        if(menu.equals("fuente")){
            fuente.add(elemMenu);

            if(tipoLetra.equals("Arial")){
                elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra" , "Arial"));
            }else if(tipoLetra.equals("Courier")){
                elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra" , "Courier"));
            }else if(tipoLetra.equals("Verdana")){
                elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra" , "Verdana"));
            }
        }/*else if(menu.equals("estilo")){
            estilo.add(elemMenu);

            if(estilos == Font.BOLD){
                elemMenu.addActionListener(new StyledEditorKit.BoldAction());
            }else if(estilos == Font.ITALIC){
                elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
            }
        }*/else if(menu.equals("tamaño")){
            tamaño.add(elemMenu);

            elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", tam));
        }

        //elemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
    }

    //PARA USAR LA CLASE -StyledEditorKit- NOS SOBRA TODA LA CLASE INTERNA

    /*private class GestionaEventos implements ActionListener{

        String tipoTexto, menu;
        int estiloLetra, tamañoLetra;

        GestionaEventos(String elemento, String texto2, int estilo2, int tamLetra){
            tipoTexto = texto2;
            estiloLetra = estilo2;
            tamañoLetra = tamLetra;
            menu = elemento;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            letras = miArea.getFont();

            if(menu.equalsIgnoreCase("Arial") || menu.equalsIgnoreCase("Courier") || menu.equalsIgnoreCase("Verdana")){
                estiloLetra = letras.getStyle();

                tamañoLetra = letras.getSize();
            }else if(menu.equalsIgnoreCase("Cursiva") || menu.equalsIgnoreCase("Negrita")){
                if(letras.getStyle() == 1 || letras.getStyle() == 2){
                    estiloLetra = 3;
                }
                
                tipoTexto = letras.getFontName();

                tamañoLetra = letras.getSize();
            }else if(menu.equalsIgnoreCase("12") || menu.equalsIgnoreCase("16") || menu.equalsIgnoreCase("20") || menu.equalsIgnoreCase("24")){
                estiloLetra = letras.getStyle();

                tipoTexto = letras.getFontName();
            }

            miArea.setFont(new Font(tipoTexto, estiloLetra, tamañoLetra));

            System.out.println("Tipo: " + tipoTexto + " Estilo: " + estiloLetra + " Tamaño: " + tamañoLetra);
        }
        
    }*/

    private JTextPane miArea;
    private JMenu fuente, estilo, tamaño;
}