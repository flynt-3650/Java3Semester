package shapereality;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

class Shape {
    int x, y, width, height;
    Color color;

    public Shape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
}

class ShapesDisplay extends JPanel {
    private final ArrayList<Shape> shapes = new ArrayList<>();

    public ShapesDisplay() {
    }

    private void generateRandomShapes(int panelWidth, int panelHeight) {
        Random random = new Random();
        int numShapes = 20;
        for (int i = 0; i < numShapes; i++) {
            int x, y, width, height;
            do {
                x = random.nextInt(panelWidth - 50);
                y = random.nextInt(panelHeight - 50);
                width = random.nextInt(50) + 1; // Ensure width is positive
                height = random.nextInt(50) + 1; // Ensure height is positive
            } while (checkOverlap(x, y, width, height));

            Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
            shapes.add(new Shape(x, y, width, height, color));
        }
    }

    private boolean checkOverlap(int x, int y, int width, int height) {
        for (Shape shape : shapes) {
            if (x < shape.x + shape.width && x + width > shape.x
                && y < shape.y + shape.height && y + height > shape.y) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            g.setColor(shape.color);
            if (shape.width < shape.height) {
                g.fillOval(shape.x, shape.y, shape.width, shape.height);
            } else {
                g.fillRect(shape.x, shape.y, shape.width, shape.height);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes Display");
        ShapesDisplay shapesDisplay = new ShapesDisplay();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(shapesDisplay);
        frame.setVisible(true);

        shapesDisplay.generateRandomShapes(frame.getWidth(), frame.getHeight());
        frame.repaint(); // Repaint the frame to display the generated shapes
    }
}
