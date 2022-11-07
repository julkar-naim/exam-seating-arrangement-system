package org.seating_arrangement_system.gui;

import javax.swing.*;
import java.awt.*;

interface FormInterface {
	JPanel makeGroup(JLabel label, JTextField field);
}

public class FormLayout extends CenteredLayout implements FormInterface {
    FormLayout() {
        setTitle("Form Layout");
        setSize(400, 300);

        topLabel.setText("Form top label");
        topLabel.setFont(new Font("SF Pro", Font.PLAIN, 18));
        topLabel.setForeground(Color.gray);

    }
    public JPanel makeGroup (JLabel label, JTextField field) {
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1, 2));
        pane.setSize(250, 50);
        pane.add(label); pane.add(field);
        return pane;
    }
}