package org.seating_arrangement_system.db.dao;

import org.seating_arrangement_system.db.models.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends Dao {

    public StudentDao() {
        super();
    }

    public List<Student> getAll() {
        String query = "select id, name from student";
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                students.add(new Student(resultSet.getInt(1), resultSet.getString(2)));
            }
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return students;
    }
}
