package org.seating_arrangement_system.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends Dao {
    public AdminDao() {super();}

    public boolean checkAdmin(String username, String password) {
        boolean ok;
        String query = "select * from admin where username = ? and password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            ok = resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ok;
    }
}
