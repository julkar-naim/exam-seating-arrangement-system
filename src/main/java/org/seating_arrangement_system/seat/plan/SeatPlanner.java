package org.seating_arrangement_system.seat.plan;

import org.seating_arrangement_system.db.dao.HallDao;
import org.seating_arrangement_system.db.dao.RoomDao;
import org.seating_arrangement_system.db.dao.SeatDao;
import org.seating_arrangement_system.db.dao.StudentDao;
import org.seating_arrangement_system.db.models.Hall;
import org.seating_arrangement_system.db.models.Room;
import org.seating_arrangement_system.db.models.Seat;
import org.seating_arrangement_system.db.models.Student;

import java.util.*;

public class SeatPlanner {

    public void truncate() {
        new SeatDao().truncate();
    }

    public void plan() {
        RoomDao roomDao = new RoomDao();
        StudentDao studentDao = new StudentDao();
        HallDao hallDao = new HallDao();

        List<Hall> hallList = hallDao.getAll();

        Map<Hall, List<Room>> hallWithRoom = new HashMap<>();

        hallList.forEach(hall -> {
            List<Room> rooms = roomDao.getAll(hall.getId());
            hallWithRoom.put(hall, rooms);
        });

        Queue<Student> studentQ = new LinkedList<>(studentDao.getAll());

        fitStudent(hallWithRoom, studentQ);
    }

    private void fitStudent(Map<Hall, List<Room>> hallMap, Queue<Student> students) {
        hallMap.forEach((hall, rooms) -> {
            rooms.forEach(room -> assignStudent(hall, room, students));
        });
    }
    private void assignStudent(Hall hall, Room room, Queue<Student> studentQ) {
        if (studentQ.isEmpty()) return;

        outer: for (int i = 0; i < room.getColumnNumber(); i++) {
            char colName = (char) (65 + i);
            for (int j = 1; j <= room.getBrenchNumber(); j++) {
                if (studentQ.isEmpty()) break outer;
                assignSeat(hall, studentQ, room, colName, j + "X");
                if (studentQ.isEmpty()) break outer;
                assignSeat(hall, studentQ, room, colName, j + "Y");
            }
        }
    }

    private static void assignSeat(Hall hall, Queue<Student> studentQ, Room room, char colName, String seat) {
        Student student = studentQ.poll();
        assert student != null;
        Seat seatInfo = new Seat(
                student.getId(),
                student.getName(),
                hall.getName() +"-"+ hall.getId(),
                room.getRoomNumber(),
                colName + seat
        );
        SeatDao seatDao = new SeatDao();
        seatDao.insertSeat(seatInfo);
    }
}
