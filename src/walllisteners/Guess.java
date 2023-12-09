/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package walllisteners;

import java.awt.FlowLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Guess extends JFrame {
    private final Random random = new Random();
    private final String mystery = String.valueOf(random.nextInt(20) + 1);
    private final JTextField textField = new JTextField(10);
    private final JButton button = new JButton("Guess!");

    Guess() {
        super("Guessing Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        add(textField);
        add(button);
        game();
    }

    private void game() {
        System.out.println(mystery);
        AtomicInteger attempts = new AtomicInteger();
        button.addActionListener(ae -> {
            try {
                String choice = textField.getText().trim();
                if (choice.equals(mystery)) {
                    JOptionPane.showMessageDialog(null, "GJ", "alert", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else if (attempts.get() < 3) {
                    String message = Integer.parseInt(choice) > Integer.parseInt(mystery) ? "more" : "less";
                    JOptionPane.showMessageDialog(null, message, "alert", JOptionPane.INFORMATION_MESSAGE);
                    attempts.incrementAndGet();
                } else {
                    JOptionPane.showMessageDialog(null, "next time", "alert", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error!", "alert", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new Guess();
    }
}
