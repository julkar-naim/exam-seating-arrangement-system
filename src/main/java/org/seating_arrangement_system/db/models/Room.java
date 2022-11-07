package org.seating_arrangement_system.db.models;

public class Room {
    private final int hallId;
    private final int roomNumber;
    private final int columnNumber;
    private final int brenchNumber;
    private final int totalCapacity;

    public Room(int hallId, int roomNumber, int columnNumber, int brenchNumber) {
        this.hallId = hallId;
        this.roomNumber = roomNumber;
        this.columnNumber = columnNumber;
        this.brenchNumber = brenchNumber;
        totalCapacity = brenchNumber * columnNumber * 2;
    }

    public int getHallId() {
        return hallId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public int getBrenchNumber() {
        return brenchNumber;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }
}
