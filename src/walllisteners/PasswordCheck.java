/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package walllisteners;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

class PasswordCheck extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField serviceField;
    private JTextField userNameField;
    private JTextField passwordField;
    private JLabel serviceLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;

    public PasswordCheck() {
        super("Password application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300, 200);
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setVisible(true);

        String actualService = "MIREA";
        String actualUserName = "Ivan Repilov";
        String actualPassword = "3729";

        buttonOK.addActionListener(e -> {
            String attemptService = serviceField.getText().trim();
            String attemptUserName = userNameField.getText().trim();
            String attemptPassword = passwordField.getText().trim();
            if (actualService.equals(attemptService)
                && actualUserName.equals(attemptUserName)
                && actualPassword.equals(attemptPassword)) {
                JOptionPane.showMessageDialog(null, "PASSWORD ACCEPTED", "alert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "PASSWORD DECLINED", "alert", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new PasswordCheck();
    }
}
