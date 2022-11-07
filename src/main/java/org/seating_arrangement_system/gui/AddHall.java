package org.seating_arrangement_system.gui;

import org.seating_arrangement_system.db.dao.HallDao;

import javax.swing.*;

public class AddHall extends FormLayout {
    AddHall() {
        setSize(400, 300);

        JLabel enterHallId = new JLabel("Enter hall id:");
        JTextField hallIdField = new JTextField(15);
        compList.add(makeGroup(enterHallId, hallIdField));

        JLabel enterHallName = new JLabel("Enter Hall Name:");
        JTextField hallNameField = new JTextField(15);

        compList.add(makeGroup(enterHallName, hallNameField));

        JPanel btnPane = new JPanel();
        JButton create = new JButton("Create");


        create.addActionListener(action -> {
            HallDao hallDao = new HallDao();
            try {
                int hallId = Integer.parseInt(hallIdField.getText());
                String hallName = hallNameField.getText();
                if (hallDao.idExists(hallId)) {
                    JOptionPane.showMessageDialog(null, "id already exists");
                }
                else if (hallDao.nameExists(hallName)) {
                    JOptionPane.showMessageDialog(null, "Hall name already exists");
                }
                else {
                    hallDao.insertHall(hallId, hallName);
                    JOptionPane.showMessageDialog(null, "Successfully added hall!");
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, "id must be an integer");
            }
        });

        JButton back = new JButton("Back");

        back.addActionListener(action -> {
            this.dispose();
            new AdminView();
        });

        btnPane.add(create);
        btnPane.add(back);

        compList.add(btnPane);
        render();
        setVisible(true);
    }
}
