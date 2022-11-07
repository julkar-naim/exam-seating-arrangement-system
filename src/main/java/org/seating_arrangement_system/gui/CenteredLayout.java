package org.seating_arrangement_system.gui;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CenteredLayout extends JFrame {
    ArrayList<Component> compList;
    JLabel topLabel;
    JPanel topPane, middlePane;
    Insets topInsets, middleInsets;

    CenteredLayout () {
        setLayout(new BorderLayout());
        compList = new ArrayList<>();
        topInsets = new Insets(20, 0, 20, 0);
        middleInsets = new Insets(0, 0, 20, 0);
        topLabel = new JLabel("");
        topPane = new JPanel();
        middlePane = new JPanel();
        topPane.setLayout(new GridBagLayout());
        middlePane.setLayout(new GridBagLayout());
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void render () {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = topInsets;
        topPane.add(topLabel, c);
        c.insets = middleInsets;

        for (int i = 0; i < compList.size(); i++) {
            c.gridy = i;
            middlePane.add(compList.get(i), c);
        }

        add(topPane, BorderLayout.NORTH);
        add(middlePane, BorderLayout.CENTER);
    }
}