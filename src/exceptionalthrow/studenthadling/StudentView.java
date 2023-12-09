/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package exceptionalthrow.studenthadling;

import exceptionalthrow.studenthadling.StudentExceptions.EmptyStringException;
import exceptionalthrow.studenthadling.StudentExceptions.StudentNotFoundException;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class StudentView extends JDialog {
    private JPanel contentPane;
    private JButton buttonSearch;
    //private JButton buttonCancel;
    private JTextField textField1;
    private JLabel enterStudentSNameLabel;
    private JButton studentsSortedByGPAButton;
    private JButton studentsSortedByIDButton;

    public StudentView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonSearch);

        buttonSearch.addActionListener(e -> onSearch());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        studentsSortedByGPAButton.addActionListener(e -> onStudentsSortedByGPA());
        studentsSortedByIDButton.addActionListener(e -> onStudentsSortedByID());
    }

    private void onStudentsSortedByID() {
        var sorted = StudentController.sortByID(StudentDataBase.getStudentDataBase());

        StringBuilder studentData = new StringBuilder();

        int count = 0;
        for (var item : sorted) {
            studentData.append(++count).append(". ").append(item).append('\n');
        }

        JOptionPane.showMessageDialog(null, "Sorted students:\n" + studentData,
            "OK", JOptionPane.INFORMATION_MESSAGE);
    }

    private void onStudentsSortedByGPA() {
        var sorted = StudentController.sortByGPA(StudentDataBase.getStudentDataBase());

        StringBuilder studentData = new StringBuilder();

        int count = 0;
        for (var item : sorted) {
            studentData.append(++count).append(". ").append(item).append('\n');
        }

        JOptionPane.showMessageDialog(null, "Sorted students:\n" + studentData,
            "OK", JOptionPane.INFORMATION_MESSAGE);

    }

    private void onSearch() {
        String takenName = textField1.getText();
        try {
            ArrayList<Student> retrieved = StudentController.retrieveStudentsByName(takenName);

            if (retrieved.isEmpty()) {
                JOptionPane.showMessageDialog(null, "0 students found\n",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (retrieved.size() == 1) {
                JOptionPane.showMessageDialog(null, "Found student:\n" + retrieved.get(0),
                    "OK", JOptionPane.INFORMATION_MESSAGE);
                return;
            }


            StringBuilder studentData = new StringBuilder();

            int count = 0;
            for (var item : retrieved) {
                studentData.append(++count).append(". ").append(item).append('\n');
            }

            JOptionPane.showMessageDialog(null, "Found students:\n" + studentData,
                "OK", JOptionPane.INFORMATION_MESSAGE);


        } catch (EmptyStringException | StudentNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        StudentView dialog = new StudentView();
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
