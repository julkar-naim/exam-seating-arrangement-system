package org.seating_arrangement_system.gui;

import com.mysql.cj.exceptions.CJOperationNotSupportedException;
import org.seating_arrangement_system.db.dao.SeatDao;
import org.seating_arrangement_system.db.models.Seat;

import javax.swing.*;
import java.awt.*;

public class SingleSeatPlan extends FormLayout {
    SingleSeatPlan() {
        setSize(400, 300);
        topLabel.setText("Enter your ID");
        topLabel.setFont(new Font("SF Pro", Font.PLAIN, 18));
        topLabel.setForeground(Color.black);
        JLabel enterName = new JLabel("Student ID: ");
        JTextField idField = new JTextField(15);
        compList.add(makeGroup(enterName, idField));

        JPanel btnPane = new JPanel();
        JButton search = new JButton("Search");

        search.addActionListener(action -> {
            SeatDao seatDao = new SeatDao();
            try {
                int id = Integer.parseInt(idField.getText());
                Seat seat = seatDao.getSeat(id);
                if (seat == null) {
                    JOptionPane.showMessageDialog(null, "Invalid id or seatplan is not made yet");
                }
                else {
                    JOptionPane.showMessageDialog(null, seat.toString());
                }
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Not a valid integer id");
            }
        });

        JButton back = new JButton("Back");

        back.addActionListener(action -> {
            this.dispose();
            new StudentView();
        });


        btnPane.add(search);
        btnPane.add(back);

        compList.add(btnPane);
        render();
        setVisible(true);
    }
}
