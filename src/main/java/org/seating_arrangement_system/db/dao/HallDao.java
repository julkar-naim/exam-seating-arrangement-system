package org.seating_arrangement_system.db.dao;

import org.seating_arrangement_system.db.models.Hall;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallDao extends Dao {

    public HallDao() { super(); }

    public List<Hall> getAll() {
        List<Hall> hallList = new ArrayList<>();
        String query = "select * from hall";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Hall hall = new Hall(resultSet.getInt(1), resultSet.getString(2));
                hallList.add(hall);
            }
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return hallList;
    }

    public boolean idExists(int id) {
        boolean ok = false;
        String query = "select * from hall where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            ok = resultSet.next();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return ok;
    }

    public void insertHall(int id, String name) {
        String query = "insert into hall(id, name) values(?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean nameExists(String hallName) {
        boolean ok = false;
        String query = "select * from hall where name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hallName);
            ResultSet resultSet = statement.executeQuery();
            ok = resultSet.next();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return ok;
    }

    public int delete(Hall hall) {
        int affected = 0;
        String query = "delete from hall where id = ? and name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hall.getId());
            statement.setString(2, hall.getName());
            affected = statement.executeUpdate();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return affected;
    }
}
