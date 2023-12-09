package shapereality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Animation extends JFrame {
    MyPanel panel = new MyPanel();
    private static final Integer PANEL_WIDTH = 1000;
    private static final Integer PANEL_HEIGHT = 1000;


    Animation() {
        super("ANIMATION EXAMPLE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel);


    }

    private static class MyPanel extends JPanel implements ActionListener {
        Timer timer;
        Image catImage;
        int x = 0;
        int y = 0;
        int xVel = 10;
        int yVel = 10;

        MyPanel() {
            catImage = new ImageIcon("C:\\Users\\Flyn_\\!importantThings\\!c0d3\\Java\\FunnyMoments21\\cat.jpg").getImage();
            timer = new Timer(10, this);
            timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (x >= PANEL_WIDTH - catImage.getWidth(null) || x < 0)
                xVel *= -1;


            if (y >= PANEL_HEIGHT - catImage.getHeight(null) || y < 0)
                yVel *= -1;

            x += xVel;
            y += yVel;
            repaint();
        }

        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(catImage, x, y, null);
        }
    }



    public static void main(String[] args) {
        new Animation();
    }
}
