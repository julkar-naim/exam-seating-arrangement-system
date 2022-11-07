package org.seating_arrangement_system.gui;

import org.seating_arrangement_system.db.dao.HallDao;
import org.seating_arrangement_system.db.dao.RoomDao;
import org.seating_arrangement_system.db.models.Hall;
import org.seating_arrangement_system.db.models.Room;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DeleteRoom extends FormLayout {
    public DeleteRoom() {
        setSize(400, 300);

        HallDao hallDao = new HallDao();
        List<Hall> hallList = hallDao.getAll();

        JComboBox hallSelect = new JComboBox(hallList.toArray());
        hallSelect.setSelectedIndex(0);
        compList.add(hallSelect);


        JLabel roomNoLabel = new JLabel("Enter Room Number:");
        JTextField roomNoField = new JTextField(15);
        compList.add(makeGroup(roomNoLabel, roomNoField));


        JPanel btnPane = new JPanel();

        JButton delete = new JButton("Delete");

        RoomDao roomDao = new RoomDao();

        delete.addActionListener(action -> {
            try {
                int roomNumber = Integer.parseInt(roomNoField.getText());
                Hall hall = (Hall) hallSelect.getSelectedItem();
                assert hall != null;
                int deleted = roomDao.delete(hall.getId(), roomNumber);
                if (deleted == 0) {
                    JOptionPane.showMessageDialog(null, "Room Number does not exists!");
                } else {
                    JOptionPane.showMessageDialog(null, "Room deleted successfully!");
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, "invalid room number! must be an integer");
            }
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
