import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Main extends JFrame {

    private BufferedImage background;
    private BufferedImage buttonLayout;
    private BufferedImage exitButton;
    private BufferedImage backButton;
    private int currentScene = 0;

    public Main() {
        try {
            background = ImageIO.read(new File("src/sprites/backgroung_main.jpg"));
            buttonLayout = ImageIO.read(new File("src/sprites/button-layout.png"));
            exitButton = ImageIO.read(new File("src/sprites/exit-button.png"));
            backButton = ImageIO.read(new File("src/sprites/back-button.png"));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки изображений", e);
        }
        setTitle("Orbital Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);

        JSlider volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setBounds(490, 350, 300, 50);
        volumeSlider.setVisible(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentScene == 0) {
                    g.drawImage(background, 0, 0, this);
                    g.drawImage(buttonLayout, 512, 400, this);
                    g.drawImage(buttonLayout, 512, 500, this);
                    g.drawImage(exitButton, 20, 20, this);
                    g.setColor(new Color(30, 30, 30));
                    g.setFont(new Font("Arial", Font.BOLD, 24));
                    FontMetrics fm = g.getFontMetrics();
                    int tX = 512 + (buttonLayout.getWidth() - fm.stringWidth("Играть")) / 2;
                    int tY = 397 + (buttonLayout.getHeight() + fm.getAscent()) / 2;
                    g.drawString("Играть", tX, tY);
                    int settingsX = 512 + (buttonLayout.getWidth() - fm.stringWidth("Настройки")) / 2;
                    int settingsY = 497 + (buttonLayout.getHeight() + fm.getAscent()) / 2;
                    g.drawString("Настройки", settingsX, settingsY);
                }
                else if (currentScene == 1) {
                    g.setColor(new Color(20, 40, 100));
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.drawImage(buttonLayout, 512, 400, this);
                    g.drawImage(backButton, 70, 50, this);
                    g.setColor(new Color(30, 30, 30));
                    g.setFont(new Font("Arial", Font.BOLD, 24));
                    FontMetrics fm = g.getFontMetrics();
                    int tX = 512 + (buttonLayout.getWidth() - fm.stringWidth("Начать")) / 2;
                    int tY = 397 + (buttonLayout.getHeight() + fm.getAscent()) / 2;
                    g.drawString("Начать", tX, tY);
                }
                else if (currentScene == 2) {
                    g.setColor(new Color(20, 40, 100));
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.drawImage(backButton, 70, 50, this);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Arial", Font.BOLD, 28));
                    g.drawString("Настройки", 560, 280);
                    g.drawString("Громкость", 560, 330);
                }
                else if (currentScene == 3) {
                    g.setColor(new Color(10, 20, 40));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        panel.setLayout(null);
        panel.add(volumeSlider);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();
                if (currentScene == 0 &&
                        x >= 512 && x <= 512 + buttonLayout.getWidth() &&
                        y >= 400 && y <= 400 + buttonLayout.getHeight()) {
                    currentScene = 1;
                }

                else if (currentScene == 0 &&
                        x >= 512 && x <= 512 + buttonLayout.getWidth() &&
                        y >= 500 && y <= 500 + buttonLayout.getHeight()) {

                    currentScene = 2;
                }

                else if (currentScene == 1 &&
                        x >= 512 && x <= 512 + buttonLayout.getWidth() &&
                        y >= 400 && y <= 400 + buttonLayout.getHeight()) {

                    currentScene = 3;
                }

                if (currentScene == 1 &&
                        x >= 70 && x <= 70 + backButton.getWidth() &&
                        y >= 50 && y <= 50 + backButton.getHeight()) {
                    currentScene = 0;
                }

                if (currentScene == 2 &&
                        x >= 70 && x <= 70 + backButton.getWidth() &&
                        y >= 50 && y <= 50 + backButton.getHeight()) {
                    currentScene = 0;
                }

                else if (currentScene == 0 &&
                        x >= 20 && x <= 20 + exitButton.getWidth() &&
                        y >= 20 && y <= 20 + exitButton.getHeight()) {

                    System.exit(0);
                }

                volumeSlider.setVisible(currentScene == 2);
                panel.repaint();
            }
        });
        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::new);

    }

}
