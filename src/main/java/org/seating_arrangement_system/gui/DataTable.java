package org.seating_arrangement_system.gui;

import javax.swing.*;


public class DataTable extends JFrame {

    DataTable (Object[][] data, String[] headers) {

        setSize(700, 300);

        JTable table = new JTable(data, headers);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }
    void render () {
    	setVisible(true);
    }
}