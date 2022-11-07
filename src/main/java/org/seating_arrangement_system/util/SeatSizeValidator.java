package org.seating_arrangement_system.util;


import org.seating_arrangement_system.db.dao.HallDao;
import org.seating_arrangement_system.db.dao.RoomDao;
import org.seating_arrangement_system.db.dao.StudentDao;
import org.seating_arrangement_system.db.models.Hall;
import org.seating_arrangement_system.db.models.Room;
import org.seating_arrangement_system.db.models.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatSizeValidator {
    Map<Hall, List<Room>> hallWithRoom;
    int studentSize;

    public SeatSizeValidator() {
        hallWithRoom = new HashMap<>();
        HallDao hallDao = new HallDao();
        RoomDao roomDao = new RoomDao();
        studentSize = new StudentDao().getAll().size();

        hallDao.getAll().forEach(hall -> {
            hallWithRoom.put(hall, roomDao.getAll(hall.getId()));
        });
        hallDao.destroy();
        roomDao.destroy();
    }

    public boolean isValid() {
        int totalRoomCapacity = 0;
        for (Map.Entry<Hall, List<Room>> entry : hallWithRoom.entrySet()) {
            Hall hall = entry.getKey();
            List<Room> rooms = entry.getValue();
            for (Room room : rooms) {
                totalRoomCapacity += room.getTotalCapacity();
            }
        }
        return totalRoomCapacity >= studentSize;
    }
}
