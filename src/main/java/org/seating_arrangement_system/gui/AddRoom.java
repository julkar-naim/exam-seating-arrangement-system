package org.seating_arrangement_system.gui;

import org.seating_arrangement_system.db.dao.HallDao;
import org.seating_arrangement_system.db.dao.RoomDao;
import org.seating_arrangement_system.db.models.Hall;

import javax.swing.*;
import java.util.List;

public class AddRoom extends FormLayout {
    public AddRoom() {
        setSize(400, 400);

        topLabel.setText("Select hall");

        HallDao hallDao = new HallDao();
        List<Hall> hallList = hallDao.getAll();

        JComboBox hallSelect = new JComboBox(hallList.toArray());
        hallSelect.setSelectedIndex(0);
        compList.add(hallSelect);

        JLabel roomNoLabel = new JLabel("Room Number:");
        JTextField roomNumberField = new JTextField(15);

        compList.add(makeGroup(roomNoLabel, roomNumberField));

        JLabel colLabel = new JLabel("Column Number:");
        JTextField colField = new JTextField(15);

        compList.add(makeGroup(colLabel, colField));


        JLabel brenchNumberLabel = new JLabel("Brench per column:");
        JTextField brenchPerColumn = new JTextField(15);

        compList.add(makeGroup(brenchNumberLabel, brenchPerColumn));

        JPanel btnPane = new JPanel();

        JButton addRoomButton = new JButton("Add Room");

        addRoomButton.addActionListener(action -> {
            Hall hall = (Hall)hallSelect.getSelectedItem();
            assert hall != null;
            try {
                int roomNo = Integer.parseInt(roomNumberField.getText());
                int columnNumber = Integer.parseInt(colField.getText());
                int brenchNumber = Integer.parseInt(brenchPerColumn.getText());
                RoomDao roomDao = new RoomDao();
                if (roomDao.alreadyExists(hall.getId(), roomNo)) {
                    JOptionPane.showMessageDialog(null, "Room already exists");
                } else {
                    roomDao.add(hall.getId(), roomNo, columnNumber, brenchNumber);
                    JOptionPane.showMessageDialog(null, "Room added!");
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Input is invalid! all input must be integer");
            }

        });

        JButton back = new JButton("Back");

        back.addActionListener(action -> {
            this.dispose();
            new AdminView();
        });

        btnPane.add(addRoomButton);
        btnPane.add(back);

        compList.add(btnPane);
        render();
        setVisible(true);
    }
}
