/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package powerofnesting;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;

class ToolBar extends JFrame {
    ToolBar() {
        super("Tools & Buttons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 150);

        // Create a JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // Create File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem fileMenuItem = new JMenuItem("Save");
        JMenuItem fileMenuItem1 = new JMenuItem("Exit");
        fileMenu.add(fileMenuItem);
        fileMenu.add(fileMenuItem1);
        menuBar.add(fileMenu);

        // Create Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem editMenuItem = new JMenuItem("Copy");
        JMenuItem editMenuItem1 = new JMenuItem("Cut");
        JMenuItem editMenuItem2 = new JMenuItem("Paste");
        editMenu.add(editMenuItem);
        editMenu.add(editMenuItem1);
        editMenu.add(editMenuItem2);
        menuBar.add(editMenu);

        // Create Help menu
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // Add some content to the JFrame
        add(new JButton("Button 1"));
        add(new JButton("Button 2"));

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new ToolBar();
    }
}

