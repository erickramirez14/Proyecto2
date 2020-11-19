package proyecto_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JPanel implements ActionListener{
    // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[];
    public JMenuBar menuBar;
    public JMenu menu;
    public JMenuItem Escalar, Traslacion, Rotacion1, Rotacion2, Reflexion1, Reflexion2, Reflexion3, Restablecer;
    public JButton btEscalar, btTraslacion, btRotacion1, btRotacion2, btReflexion1, btReflexion2, btReflexion3, btRestablecer,btAumentar,btDisminuir,btInformacion;
    public MouseListener mouse;
    public JPanel panelc;
    public Ventana(String titulo, Punto[] figura) {
           
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(980, 600);
        panelc= new JPanel();
        BorderLayout layout = new BorderLayout(20, 10);
        setLayout(layout);
        menuBar = new JMenuBar();
        menu = new JMenu("Click para ver las acciones");
        menu.setBorder(BorderFactory.createLineBorder(Color.RED));
        Escalar = new JMenuItem("Escalar");
        Traslacion = new JMenuItem("Traslación");
        Rotacion1 = new JMenuItem("Rotación (+)");
        Rotacion2 = new JMenuItem("Rotación (-)");
        Reflexion1 = new JMenuItem("Reflexión (X)");
        Reflexion2 = new JMenuItem("Reflexión (Y)");
        Reflexion3 = new JMenuItem("Reflexión (XY)");
        Restablecer = new JMenuItem("Restablecer");
        
        btEscalar = new JButton("Escalar");
        btTraslacion= new JButton("Traslacion");
        btRotacion1= new JButton("Rotación (+)");
        btRotacion2= new JButton("Rotación (-)");
        btReflexion1= new JButton("Reflexión (X)");
        btReflexion2= new JButton("Reflexión (Y)");
        btReflexion3= new JButton("Reflexión (XY)");
        btRestablecer= new JButton("Restablecer");
        
        btAumentar= new JButton(new ImageIcon("src/Proyecto_2/icono-mas.png"));
        btDisminuir= new JButton(new ImageIcon("src/Proyecto_2/icono-menos.png"));
        btInformacion= new JButton(new ImageIcon("src/Proyecto_2/icono-i.png"));
        
        add(menuBar, BorderLayout.NORTH);
        add(panelc, BorderLayout.EAST);
        
        menuBar.add(menu);
        menuBar.add(btEscalar);
        menuBar.add(btTraslacion);
        menuBar.add(btRotacion1);
        menuBar.add(btRotacion2);
        menuBar.add(btReflexion1);
        menuBar.add(btReflexion2);
        menuBar.add(btReflexion3);
        menuBar.add(btRestablecer);
        
        panelc.add(btAumentar,BorderLayout.NORTH);
        panelc.add(btDisminuir,BorderLayout.CENTER);
        panelc.add(btInformacion,BorderLayout.SOUTH);
        
        menu.add(Escalar);
        menu.add(Traslacion);
        menu.add(Rotacion1);
        menu.add(Rotacion2);
        menu.add(Reflexion1);
        menu.add(Reflexion2);
        menu.add(Reflexion3);
        menu.add(Restablecer);
        
        Escalar.addActionListener(this);
        Traslacion.addActionListener(this);
        Rotacion1.addActionListener(this);
        Rotacion2.addActionListener(this);
        Reflexion1.addActionListener(this);
        Reflexion2.addActionListener(this);
        Reflexion3.addActionListener(this);
        Restablecer.addActionListener(this);
        
        btEscalar.addActionListener(this);
        btTraslacion.addActionListener(this);
        btRotacion1.addActionListener(this);
        btRotacion2.addActionListener(this);
        btReflexion1.addActionListener(this);
        btReflexion2.addActionListener(this);
        btReflexion3.addActionListener(this);
        btRestablecer.addActionListener(this);
        mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==btAumentar) {
                escalar(2.0,2.0);
                repaint();
                }else if(e.getSource()==btDisminuir){
                escalar(.5,.5);
                repaint();
                 }else if(e.getSource()==btInformacion){
                 JOptionPane.showMessageDialog(null, "Uso mouse: \n"+
                                                     "Click sobre boton con icono + : Hace que la figura aumente \n"+
                                                     "Click sobre boton con icono - : Hace que la figura disminuya  \n"+
                                                     "Click sobre boton con icono 'i' : Muestra la pantalla de informacion sobre los controles e utilizacion del programa\n\n"+
                                                     "Uso del teclado:   \n"+
                                                     "Tecla de la flechita hacia arriba : realiza un esclamieto \n "+
                                                     "Tecla 'T' : Realiza una traslacion \n "+ 
                                                     "Tecla 'P' : Realiza una rotacion de 90º positiva \n "+
                                                     "Tecla 'N' : Realiza una rotacion de 90º negativa \n "+
                                                     "Tecla 'X' : Realiza una reflexion X \n "+
                                                     "Tecla 'Y' : Realiza una reflexion Y  \n "+
                                                     "Tecla 'R' : Realiza una reflexion XY  \n "+
                                                     "Tecla 'Z' : Restablece la figura a su forma normal  \n "
                                                        );           
            }}

            @Override
            public void mousePressed(MouseEvent e) {
             }

            @Override
            public void mouseReleased(MouseEvent e) {
             }

            @Override
            public void mouseEntered(MouseEvent e) {
             }

            @Override
            public void mouseExited(MouseEvent e) {
             }
        };
        btAumentar.addMouseListener(mouse);
        btDisminuir.addMouseListener(mouse);
        btInformacion.addMouseListener(mouse);

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 800);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura=figura;
        ventana.setFocusable(true);
        ventana.addKeyListener(new Listener(this));
    
     } 
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Escalar ) {
            double x, y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de x"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de y"));
            this.escalar(x, y);
            repaint();
        }else if (e.getSource()== btEscalar) {
            this.escalar(1.5,1.5 );
            repaint();
        }
        else if (e.getSource() == Traslacion) {
            int x, y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de x"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de y"));
                this.traslacion(x,y);
                repaint();
        }
       else if( e.getSource()== btTraslacion){
                this.traslacion(100,100);
                repaint();
        }
        else if(e.getSource() == Rotacion1){
            Double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
                this.rotacion(angulo);
                repaint();
                
        }else if (e.getSource()== btRotacion1) {
            this.rotacion(45);
                repaint();
        }
        else if(e.getSource() == Rotacion2  ){
             Double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
                this.rotacion2(angulo);    
                 repaint();
        }else if (e.getSource()== btRotacion2) {
           this.rotacion2(45);    
                 repaint(); 
        }
        else if(e.getSource() == Reflexion1 || e.getSource()== btReflexion1){
                this.reflexionX();
                repaint();
        }
        else if(e.getSource() == Reflexion2 || e.getSource()== btReflexion2){
                this.reflexionY();
                repaint();
        }
        else if(e.getSource() == Reflexion3 || e.getSource()== btReflexion3){
                this.reflexionXY();
                repaint();
        }else if (e.getSource() == Restablecer || e.getSource()== btRestablecer) {
            Punto figura[] = {
             new Punto(100+190,210+100), 
             new Punto(100+187,210+100), 
             new Punto(100+184,209+100), 
             new Punto(100+179,208+100), 
             new Punto(100+177,206+100), 
             new Punto(100+173,207+100), 
             new Punto(100+176,209+100), 
             new Punto(100+177,209+100), 
             new Punto(100+182,212+100),
             new Punto(100+185,214+100),//10
             new Punto(100+185,215+100),
             new Punto(100+193,217+100), 
             new Punto(100+192,220+100), 
             new Punto(100+192,222+100), 
             new Punto(100+195,224+100), 
             new Punto(100+197,224+100), 
             new Punto(100+199,223+100), 
             new Punto(100+200,220+100), 
             new Punto(100+200,218+100), 
             new Punto(100+199,218+100),//20
             new Punto(100+198,216+100), 
             new Punto(100+197,216+100), 
             new Punto(100+199,212+100), 
             new Punto(100+200,202+100), 
             new Punto(100+199,200+100), 
             new Punto(100+207,194+100), 
             new Punto(100+206,193+100), 
             new Punto(100+207,193+100), 
             new Punto(100+209,190+100), 
             new Punto(100+214,179+100),//30
             new Punto(100+217,179+100), 
             new Punto(100+218,178+100),
             new Punto(100+218,177+100), 
             new Punto(100+212,176+100), 
             new Punto(100+211,177+100), 
             new Punto(100+211,178+100), 
             new Punto(100+208,183+100), 
             new Punto(100+208,184+100), 
             new Punto(100+206,187+100), 
             new Punto(100+206,189+100),//40
             new Punto(100+205,190+100), 
             new Punto(100+201,188+100), 
             new Punto(100+198,191+100),
             new Punto(100+197,189+100), 
             new Punto(100+196,189+100), 
             new Punto(100+194,186+100), 
             new Punto(100+192,186+100), 
             new Punto(100+180,191+100), 
             new Punto(100+174,188+100), 
             new Punto(100+173,189+100), //50
             new Punto(100+178,205+100), 
             new Punto(100+179,195+100), 
             new Punto(100+180,193+100),
             new Punto(100+185,192+100), 
             new Punto(100+189,192+100), 
             new Punto(100+191,190+100), 
             new Punto(100+192,191+100), 
             new Punto(100+191,191+100), 
             new Punto(100+192,196+100), 
             new Punto(100+192,201+100), //60
             new Punto(100+193,203+100), 
             new Punto(100+190,210+100),
             };
    
        restablecer(figura);
        repaint();
        }}
    
     class Listener implements KeyListener{
        Ventana ventana;

        
        public Listener(Ventana ventana){
        this.ventana = ventana;
        }
        @Override
        public void keyTyped(KeyEvent e) {
          }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode()== KeyEvent.VK_UP) {
                ventana.escalar(2, 2);
                repaint();
            } else if(ke.getKeyCode()== KeyEvent.VK_T) {
            ventana.traslacion(55, 55);
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_P){
                ventana.rotacion(90);
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_N){
                ventana.rotacion2(90);
                repaint();
        }else if(ke.getKeyCode()== KeyEvent.VK_X){
                ventana.reflexionX();
                repaint();
        }else if(ke.getKeyCode()== KeyEvent.VK_Y){
                ventana.reflexionY();
                repaint();
        }else if(ke.getKeyCode()== KeyEvent.VK_R){
                ventana.reflexionXY();
                repaint();
        }else if(ke.getKeyCode()== KeyEvent.VK_Z){
            Punto figura[] = {
             new Punto(100+190,210+100), 
             new Punto(100+187,210+100), 
             new Punto(100+184,209+100), 
             new Punto(100+179,208+100), 
             new Punto(100+177,206+100), 
             new Punto(100+173,207+100), 
             new Punto(100+176,209+100), 
             new Punto(100+177,209+100), 
             new Punto(100+182,212+100),
             new Punto(100+185,214+100),//10
             new Punto(100+185,215+100),
             new Punto(100+193,217+100), 
             new Punto(100+192,220+100), 
             new Punto(100+192,222+100), 
             new Punto(100+195,224+100), 
             new Punto(100+197,224+100), 
             new Punto(100+199,223+100), 
             new Punto(100+200,220+100), 
             new Punto(100+200,218+100), 
             new Punto(100+199,218+100),//20
             new Punto(100+198,216+100), 
             new Punto(100+197,216+100), 
             new Punto(100+199,212+100), 
             new Punto(100+200,202+100), 
             new Punto(100+199,200+100), 
             new Punto(100+207,194+100), 
             new Punto(100+206,193+100), 
             new Punto(100+207,193+100), 
             new Punto(100+209,190+100), 
             new Punto(100+214,179+100),//30
             new Punto(100+217,179+100), 
             new Punto(100+218,178+100),
             new Punto(100+218,177+100), 
             new Punto(100+212,176+100), 
             new Punto(100+211,177+100), 
             new Punto(100+211,178+100), 
             new Punto(100+208,183+100), 
             new Punto(100+208,184+100), 
             new Punto(100+206,187+100), 
             new Punto(100+206,189+100),//40
             new Punto(100+205,190+100), 
             new Punto(100+201,188+100), 
             new Punto(100+198,191+100),
             new Punto(100+197,189+100), 
             new Punto(100+196,189+100), 
             new Punto(100+194,186+100), 
             new Punto(100+192,186+100), 
             new Punto(100+180,191+100), 
             new Punto(100+174,188+100), 
             new Punto(100+173,189+100), //50
             new Punto(100+178,205+100), 
             new Punto(100+179,195+100), 
             new Punto(100+180,193+100),
             new Punto(100+185,192+100), 
             new Punto(100+189,192+100), 
             new Punto(100+191,190+100), 
             new Punto(100+192,191+100), 
             new Punto(100+191,191+100), 
             new Punto(100+192,196+100), 
             new Punto(100+192,201+100), //60
             new Punto(100+193,203+100), 
             new Punto(100+190,210+100),
             };
    
        restablecer(figura);
        repaint();  
        }
            }
        @Override
        public void keyReleased(KeyEvent e) {
            }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        //Dibujar la figura original
        g.setColor(Color.darkGray);
        this.dibujar(g);
        
    }
   public void restablecer(Punto [] figura){
        this.figura = figura;
    }
    
    
    private void escalar(double fx, double fy){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for(Punto punto : figura){
        //Nueva x: ((a-tx) * fx) + tx
            punto.setX(
                (int)((punto.getX() - tx) * fx + tx)
            );
        //Nueva y: ((a-ty) * fy) + ty
            punto.setY(
                (int)((punto.getY() - ty) * fy + ty)
            );
        }
    }
    
    private void traslacion(double xf, double yf){
        for(Punto punto : figura){
        //Nueva x: a + xf
            punto.setX(
                (int)(punto.getX() + xf)
            );
        //Nueva y: a + yf
            punto.setY(
                (int)(punto.getY() + yf)
            );
        }
    }
   
    
    public void rotacion(double ang){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            //Nueva x: (x - tx) * cos ang - (y - ty) * sen ang + tx
            punto.setX(
                    (int)(((punto.getX() - tx ) * Math.cos(Math.toRadians(ang)) - ((punto.getY() - ty) * Math.sin(Math.toRadians(ang)))) + tx)
            );
            //Nueva x: (x - tx) * sen ang + (y - ty) * cos ang + 
            punto.setY(
                    (int)(((punto.getX() - tx ) * Math.sin(Math.toRadians(ang)) + ((punto.getY() - ty) * Math.cos(Math.toRadians(ang)))) + ty)
            );
        }
    }
    
    public void rotacion2(double ang){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            //Nueva x: (x - tx) * cos ang + (y - ty) * sen ang + tx
            punto.setX(
                    (int)((punto.getX() - tx) * Math.cos(Math.toRadians(ang)) + (punto.getY() - ty)*Math.sin(Math.toRadians(ang)) + tx)
            );
            //Nueva x: -1 * (x - tx) * sen ang + (y - ty) * cos ang + ty
            punto.setY(
                    (int)((-1)*(punto.getX() - tx) * Math.sin(Math.toRadians(ang)) + (punto.getY() - ty)*Math.cos(Math.toRadians(ang)) + ty)
            ); 
        }
    }
    
    private void reflexionX(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for(Punto punto : figura){
        //Nueva x: -1 * (x - tx) + tx
            punto.setX(
                (int)(-(punto.getX() - tx) + tx)
            );
        //Nueva y: (y - ty) + ty
            punto.setY(
                (int)((punto.getY() - ty) + ty)
            );
        }
    }
    
    private void reflexionY(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for(Punto punto : figura){
        //Nueva x: (x - tx) + tx
            punto.setX(
                (int)((punto.getX() - tx) + tx)
            );
        //Nueva y: -1 * (y - ty) + ty
            punto.setY(
                (int)(-(punto.getY() - ty) + ty)
            );
        }
    }
    
    private void reflexionXY(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for(Punto punto : figura){
        //Nueva x: -1 * (x - tx) + tx
            punto.setX(
                (int)(-(punto.getX() - tx) + tx)
            );
        //Nueva y: -1 * (y - ty) + ty
            punto.setY(
                (int)(-(punto.getY() - ty) + ty)
            );
        }
    }
    
    private void dibujar(Graphics g){
        for (int i = 0; i < figura.length-1; i++) {
            g.drawLine(
                figura[i].getX(),//Punto A
                figura[i].getY(),
                figura[i+1].getX(),
                figura[i+1].getY()//Punto B
            );
        }
    }
}


