/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package powerofnesting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

class CountrySelector extends JFrame {
    CountrySelector() {
        super("Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(600, 150);

        add(new JLabel("select your country: "));
        add(new JComboBox<>(new String[]{"Australia", "China", "Great Britain", "Russia"}));

        setVisible(true);
    }

    public static void main(String[] args) { new CountrySelector(); }
}