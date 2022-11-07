package org.seating_arrangement_system.db.models;

public class Student {
    private final int id;
    private final String name;


    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}
