package shapereality;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

class ImageDisplay extends JFrame {
    ImageDisplay(String @NotNull [] path) {
        super("FUNNY CAT");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        if (path.length == 0) {
            return;
        }

        ImageIcon imageIcon = new ImageIcon(path[0]);
        JLabel label = new JLabel(imageIcon);
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageDisplay(args);
    }
}
