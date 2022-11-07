package org.seating_arrangement_system.db.dao;

import org.seating_arrangement_system.db.models.Hall;
import org.seating_arrangement_system.db.models.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao extends Dao {

    public RoomDao() {
        super();
    }

    public List<Room> getAll(int hall_id) {
        List<Room> rooms = new ArrayList<Room>();
        String query = "select * from room where hall_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hall_id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                        );
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public boolean alreadyExists(int hallId, int roomNo) {
        boolean exists = false;
        String query = "select * from room where hall_id = ? and room_no = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hallId);
            statement.setInt(2, roomNo);
             ResultSet resultSet = statement.executeQuery();
             exists = resultSet.next();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return exists;
    }

    public void add(int hallId, int roomNo, int col, int brenchNumber) {
        String query = "insert into room(hall_id, room_no, col, brench_per_col) values(?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hallId);
            statement.setInt(2, roomNo);
            statement.setInt(3, col);
            statement.setInt(4, brenchNumber);
            statement.executeUpdate();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public int delete(int hallId, int roomNo) {
        int affected = 0;
        String query = "delete from room where hall_id = ? and room_no = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hallId);
            statement.setInt(2, roomNo);
            affected = statement.executeUpdate();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return affected;
    }
}
