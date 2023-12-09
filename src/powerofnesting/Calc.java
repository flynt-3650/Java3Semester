/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * https://t.me/MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package powerofnesting;

import javax.swing.*;

public class Calc extends JFrame{
    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton bPoint;
    private JButton bEquals;
    private JButton bMultiply;
    private JButton bDivide;
    private JButton bPlus;
    private JButton bMinus;
    private JPanel MainPanel;
    private JLabel displayLabel;

    // important
    private String operand1 = "";
    private String operand2 = "";
    private char operator = ' ';
    Boolean isOperandSwitched = false;

    Calc() {
        super("Calc");
        setContentPane(MainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        System.out.println("isOperandSwitched=" + isOperandSwitched);

        bDivide.addActionListener(e -> {
            if (operand1.isEmpty())
                return;

            operator = '/';
            isOperandSwitched = true; // Set to true only when switching to operand2
            displayLabel.setText(operand1 + ' ' + operator + ' ');
        });

        bMultiply.addActionListener(e -> {
            if (operand1.isEmpty())
                return;

            operator = '*';
            isOperandSwitched = true; // Set to true only when switching to operand2
            displayLabel.setText(operand1 + ' ' + operator + ' ');
        });

        bMinus.addActionListener(e -> {
            if (operand1.isEmpty())
                return;

            operator = '-';
            isOperandSwitched = true; // Set to true only when switching to operand2
            displayLabel.setText(operand1 + ' ' + operator + ' ');
        });

        bPlus.addActionListener(e -> {
            if (operand1.isEmpty())
                return;

            operator = '+';
            isOperandSwitched = true; // Set to true only when switching to operand2
            displayLabel.setText(operand1 + ' ' + operator + ' ');
        });

        if (!isOperandSwitched) { // if we're working w/ 1st operand
            b7.addActionListener(e -> {
                operand1 += "7";
                displayLabel.setText(operand1);
            });

            b4.addActionListener(e -> {
                operand1 += "4";
                displayLabel.setText(operand1);
            });

            b1.addActionListener(e -> {
                operand1 += "1";
                displayLabel.setText(operand1);
            });

            b0.addActionListener(e -> {
                operand1 += "0";
                displayLabel.setText(operand1);
            });

            b8.addActionListener(e -> {
                operand1 += "8";
                displayLabel.setText(operand1);
            });

            b5.addActionListener(e -> {
                operand1 += "5";
                displayLabel.setText(operand1);
            });

            b2.addActionListener(e -> {
                operand1 += "2";
                displayLabel.setText(operand1);
            });

            bPoint.addActionListener(e -> {
                operand1 += ".";
                displayLabel.setText(operand1);
            });

            b9.addActionListener(e -> {
                operand1 += "9";
                displayLabel.setText(operand1);
            });

            b6.addActionListener(e -> {
                operand1 += "6";
                displayLabel.setText(operand1);
            });

            b3.addActionListener(e -> {
                operand1 += "3";
                displayLabel.setText(operand1);
            });
        } else {
            b7.addActionListener(e -> {
                operand2 += "7";
                displayLabel.setText(operand2);
            });

            b4.addActionListener(e -> {
                operand2 += "4";
                displayLabel.setText(operand2);
            });

            b1.addActionListener(e -> {
                operand2 += "1";
                displayLabel.setText(operand2);
            });

            b0.addActionListener(e -> {
                operand2 += "0";
                displayLabel.setText(operand2);
            });

            b8.addActionListener(e -> {
                operand2 += "8";
                displayLabel.setText(operand2);
            });

            b5.addActionListener(e -> {
                operand2 += "5";
                displayLabel.setText(operand2);
            });

            b2.addActionListener(e -> {
                operand2 += "2";
                displayLabel.setText(operand2);
            });

            bPoint.addActionListener(e -> {
                operand2 += ".";
                displayLabel.setText(operand2);
            });

            b9.addActionListener(e -> {
                operand2 += "9";
                displayLabel.setText(operand2);
            });

            b6.addActionListener(e -> {
                operand2 += "6";
                displayLabel.setText(operand2);
            });

            b3.addActionListener(e -> {
                operand2 += "3";
                displayLabel.setText(operand2);
            });
        }

        bEquals.addActionListener(e -> {
            System.out.println("op.1: " + operand1);
            System.out.println("operator: " + operator);
            System.out.println("op.2: " + operand2);
            
            double numericOperand1 = Double.parseDouble(operand1);
            double numericOperand2 = Double.parseDouble(operand2);

            if (operator == '*') {
                System.out.println(numericOperand1 * numericOperand2);
                operand1 = "";
                operand2 = "";
                operator = ' ';
            } else if (operator == '/') {
                System.out.println(numericOperand1 / numericOperand2);
                operand1 = "";
                operand2 = "";
                operator = ' ';
            } else if (operator == '+') {
                System.out.println(numericOperand1 + numericOperand2);
                operand1 = "";
                operand2 = "";
                operator = ' ';
            } else if (operator == '-') {
                System.out.println(numericOperand1 - numericOperand2);
                operand1 = "";
                operand2 = "";
                operator = ' ';
            } else {
                System.out.println("HOW THE FUCK DID U DO THIS?");
                operand1 = "";
                operand2 = "";
                operator = ' ';
            }
        });
    }

    public static void main(String[] args) {
        new Calc();
    }
}

