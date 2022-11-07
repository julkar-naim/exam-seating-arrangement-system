package org.seating_arrangement_system.db.models;

import java.util.Objects;

public class Hall {
    private final int id;
    private final String name;

    public Hall(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return id == hall.id && Objects.equals(name, hall.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
