import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame {

    //private final JButton throttle = new JButton("exit");
    //private final JButton engine = new JButton("ENGINE OFF");
    //private final JButton abs = new JButton("ABS: ON");
   // private final JButton run = new JButton("START");
    //private final JButton reset = new JButton("RESET");
    //private final JButton turnLeft = new JButton("<");
    //private final JButton turnRight = new JButton(">");

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getPoint().y+" "+e.getPoint().x);
            if(((e.getPoint().x>1200)&&(e.getPoint().y>50))&&((e.getPoint().x<1264)&&(e.getPoint().y<114)))
            {
                System.exit(0);
            }
        }

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

    Main()
    {
        try {
            background = ImageIO.read(new File("C:/Users/ivanovga.28/java/Orbital_Calculator/src/sprites/backgroung_main.jpg"));
            button_lay_1 = ImageIO.read(new File("C:/Users/ivanovga.28/java/Orbital_Calculator/src/sprites/button-layout.png"));
            exit_button = ImageIO.read(new File("C:/Users/ivanovga.28/java/Orbital_Calculator/src/sprites/exit-button.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setVisible(true);
        setTitle("Orbital Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        //add(throttle);
        //add(engine);
        //add(abs);
        //add(run);
        //add(reset);
        //add(turnLeft);
        //add(turnRight);
        addMouseListener(ml);

    }
    public BufferedImage background;
    public BufferedImage button_lay_1;
    public BufferedImage exit_button;

    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawLine(400, 50, 450, 200);  //1
        g.drawLine(450, 200, 650, 230); //2
        g.drawLine(650, 230, 480, 340); //3
        g.drawLine(480, 340, 540, 520); //4
        g.drawLine(540, 520, 400, 440); //5
        g.drawLine( 400, 440,260, 520); //6
        g.drawLine(260, 520, 300, 340); //7
        g.drawLine(300, 340, 150,230); //8
        g.drawLine(150,230, 350, 200); //9
        g.drawLine(400, 50, 350, 200);  //1
        g.drawImage(background, 0, 0, this);
        g.drawImage(button_lay_1, 560, 400, this);
        g.drawImage(exit_button, 1200, 50, this);

    }

    public static void main (String[] args)
    {
        new Main();
    }




}

