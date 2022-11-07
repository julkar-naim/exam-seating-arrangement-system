package org.seating_arrangement_system.gui;

import org.seating_arrangement_system.db.models.Seat;
import org.seating_arrangement_system.seat.plan.SeatPlanner;
import org.seating_arrangement_system.util.SeatSizeValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminView extends CenteredLayout {
    AdminView () {
        topLabel.setText("Admin Section");
        topLabel.setFont(new Font("SF Pro", Font.PLAIN, 25));
        topLabel.setForeground(Color.black);

        topInsets = new Insets(40, 0, 0, 0);

        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton addHall = new JButton("Add Hall");

        addHall.addActionListener(action -> {
            this.dispose();
            new AddHall();
        });

        
        compList.add(addHall);

        JButton addRoom = new JButton("Add Room");

        addRoom.addActionListener(action -> {
            this.dispose();
            new AddRoom();
        });
        
        compList.add(addRoom);

        JButton delHall = new JButton("Delete Hall");

        delHall.addActionListener(action -> {

        });

        
        compList.add(delHall);

        JButton delRoom = new JButton("Delete Room");

        delRoom.addActionListener(action -> {
            this.dispose();
            new DeleteRoom();
        });

        delHall.addActionListener(action -> {
            this.dispose();
            new DeleteHall();
        });


        compList.add(delRoom);

        JButton logout = new JButton("Logout");

        logout.addActionListener(action -> {
            this.dispose();
            new Welcome();
        });


        JButton generate = new JButton("Generate Seatplan");

        generate.addActionListener(action -> {
            SeatSizeValidator sizeValidator = new SeatSizeValidator();
            if (!sizeValidator.isValid()) {
                JOptionPane.showMessageDialog(null, "Not enough seat! Please add hall and room");
            } else {
                SeatPlanner seatPlanner = new SeatPlanner();
                seatPlanner.truncate();
                seatPlanner.plan();
                JOptionPane.showMessageDialog(null, "Seatplan successfull!");
            }
        });

        compList.add(generate);
        compList.add(logout);

        render();
        setVisible(true);
    }
}