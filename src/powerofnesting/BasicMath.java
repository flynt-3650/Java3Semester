/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package powerofnesting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;

class BasicMath extends JFrame {
    JTextField jta1 = new JTextField(10);
    JTextField jta2 = new JTextField(10);
    JButton button = new JButton("Do the stuff");

    BasicMath() {
        super("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(250, 150);

        add(new JLabel("1st Number"));
        add(jta1);
        add(new JLabel("2nd Number"));
        add(jta2);
        add(button);
        // add ActionListener
        button.addActionListener(ae -> {
            try {
                // var for 1st window
                double x1 = Double.parseDouble(jta1.getText().trim());
                // var for 2nd window
                double x2 = Double.parseDouble(jta2.getText().trim());
                //INFORMATION_MESSAGE
                JOptionPane.showMessageDialog(null,
                    "Addition result = " + (x1 + x2) + '\n'
                        + "Subtraction result = " + (x1 - x2) + '\n'
                        + "Multiplication result = " + (x1 * x2) + '\n'
                        + "Division result = " + (x1 / x2), "Alert", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                //ERROR_MESSAGE
                JOptionPane.showMessageDialog(null, "Error in Numbers!", "alert", JOptionPane.ERROR_MESSAGE);
            }
        }); // end of button.addActionListener()
        setVisible(true);
    }

    public static void main(String[] args) {
        new BasicMath();
    }
}