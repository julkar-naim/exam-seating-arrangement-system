package org.seating_arrangement_system.db.dao;

import org.seating_arrangement_system.db.models.Seat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeatDao extends Dao {

    public SeatDao() { super(); }

    public Object[][] getAll () {
        int rowSize = 0;
        Object[][] ret = null;
        try {
            String query = "select * from seatplan";
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = stmt.executeQuery(query);

            if (result.last()) {
                rowSize = result.getRow();
                result.first();
            }
            int colSize = 5;

            ret = new Object[rowSize][colSize];

            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    ret[i][j] = result.getString(j + 1);
                }
                result.next();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }

    public Seat getSeat(int studentId) {
        Seat seat = null;
        String query = "select * from seatplan where student_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                seat = new Seat(
                        studentId,
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5)
                );
            }
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return seat;
    }

    public void insertSeat(Seat seat) {
        String query = "insert into seatplan(student_id, student_name, hall_info, room_no, seat_id) values(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, seat.getStudentId());
            statement.setString(2, seat.getStudentName());
            statement.setString(3, seat.getHallInfo());
            statement.setInt(4, seat.getRoomNo());
            statement.setString(5, seat.getSeatId());
            int updated = statement.executeUpdate();
            System.out.println(updated);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void truncate() {
        String query = "truncate table seatplan";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
