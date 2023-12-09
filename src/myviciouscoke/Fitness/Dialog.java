/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Fitness;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField enterClientSNameTextField;

    public Dialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String name = enterClientSNameTextField.getText();
        ArrayList<Client> item = ClientController.retrieveClientFromDataBase(name);

        if (item.isEmpty()) {
            JOptionPane.showMessageDialog(null, "0 Clients found", "alert", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

        StringBuilder clientData = new StringBuilder();

        int count = 1;
        for (final var clientInfo : item)
            clientData.append(++count).append(". ").append(ClientView.updateClientDetails(clientInfo)).append('\n');


        JOptionPane.showMessageDialog(null, "Potential clients:\n" + clientData,
            "OK", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        Dialog dialog = new Dialog();

        dialog.setTitle("ACCESS DB");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        System.exit(0);
    }
}
