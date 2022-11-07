package org.seating_arrangement_system.gui;

import org.seating_arrangement_system.db.dao.HallDao;
import org.seating_arrangement_system.db.models.Hall;

import javax.swing.*;
import java.util.List;

public class DeleteHall extends FormLayout {
    public DeleteHall() {
        setSize(400, 300);

        topLabel.setText("Select hall");

        HallDao hallDao = new HallDao();
        List<Hall> hallList = hallDao.getAll();

        JComboBox hallSelect = new JComboBox(hallList.toArray());
        hallSelect.setSelectedIndex(0);
        compList.add(hallSelect);

        JPanel btnPane = new JPanel();

        JButton delete = new JButton("Delete");

        delete.addActionListener(action -> {
            Hall hall = (Hall)hallSelect.getSelectedItem();
            assert hall != null;
            System.out.println(hall);
            hallDao.delete(hall);
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
        });

        JButton back = new JButton("Back");

        back.addActionListener(action -> {
            this.dispose();
            new AdminView();
        });

        btnPane.add(delete);
        btnPane.add(back);

        compList.add(btnPane);
        render();
        setVisible(true);
    }
}
