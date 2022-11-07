package org.seating_arrangement_system.gui;

import org.seating_arrangement_system.db.dao.SeatDao;
import org.seating_arrangement_system.db.models.Seat;

import javax.swing.*;
import java.awt.*;

public class StudentView extends CenteredLayout {
    StudentView() {
        this.setTitle("Student View");

        JButton viewAll = new JButton("View All seatplan");
        JButton viewSingle = new JButton("View single seatplan");

        viewAll.addActionListener(action -> {
            String[] headers = {"Student Id" , "Student Name", "Hall Info", "Room No", "Seat Id"};
            SeatDao seatDao = new SeatDao();
            DataTable dataTable = new DataTable(seatDao.getAll(), headers);
            dataTable.render();
        });

        viewSingle.addActionListener(action -> {
            this.dispose();
            new SingleSeatPlan();
        });

        JButton back = new JButton("Back");

        back.addActionListener(action -> {
            this.dispose();
            new Welcome();
        });

        compList.add(viewAll);
        compList.add(viewSingle);
        compList.add(back);

        render();
        setVisible(true);
    }
}
