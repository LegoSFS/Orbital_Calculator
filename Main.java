import javax.swing.;
import java.awt.;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {

private BufferedImage background;
private BufferedImage futureButton;
private BufferedImage exitButton;

public Main() {

    try {
        background = ImageIO.read(
                new File("src/sprites/backgroung_main.jpg"));

        startButton = ImageIO.read(
                new File("src/sprites/button-layout.png"));

        exitButton = ImageIO.read(
                new File("src/sprites/exit-button.png"));

    } catch (IOException e) {
        throw new RuntimeException("Ошибка загрузки изображений", e);
    }

    setTitle("Orbital Calculator");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1280, 720);
    setResizable(false);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel() {

        @id86240433 (@Override)
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, this);
            g.drawImage(startButton, 560, 400, this);
            g.drawImage(exitButton, 1200, 50, this);
        }
    };

    panel.addMouseListener(new MouseAdapter() {

        @id86240433 (@Override)
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (x >= 1200 && x <= 1264 &&
                y >= 50 && y <= 114) {

                System.exit(0);
            }
        }
    });

    setContentPane(panel);
    setVisible(true);
}

public static void main(String[] args) {

    SwingUtilities.invokeLater(Main::new);

}

}
