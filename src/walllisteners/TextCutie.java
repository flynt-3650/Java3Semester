/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package walllisteners;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

class TextCutie extends JFrame {
    private JTextArea textArea;
    private JComboBox colorBox;
    private JComboBox fontBox;
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TextCutie");
        frame.setContentPane(new TextCutie().mainPanel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public TextCutie() {
        colorBox.addActionListener(e -> {
            String color = String.valueOf(colorBox.getSelectedItem());
            switch (color) {
                case "Blue":
                    textArea.setForeground(Color.BLUE);
                    break;
                case "Red":
                    textArea.setForeground(Color.RED);
                    break;
                case "Black":
                    textArea.setForeground(Color.BLACK);
                    break;
                default:
                    // Default to black if none of the expected colors are selected
                    textArea.setForeground(Color.WHITE);
                    break;
            }
        });

        fontBox.addActionListener(e -> {
            String fontName = String.valueOf(fontBox.getSelectedItem());
            Font currentFont = textArea.getFont();
            textArea.setFont(new Font(fontName, Font.BOLD, currentFont.getSize()));
        });
    }

}
