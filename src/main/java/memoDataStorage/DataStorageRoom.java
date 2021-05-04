package memoDataStorage;

import model.entity.Hotel;
import model.entity.Room;
import java.util.ArrayList;
import java.util.List;

public class DataStorageRoom {
    private static Long rooms_id_sequence = 0L;
    private final static Hotel hotel = new Hotel(new ArrayList<>(20)); // обработать ощибку

    private static Long generateRoomId() {
        return rooms_id_sequence++;
    }

    public static Room createRoom(Room room) {
        room.setId(generateRoomId());
        hotel.getRooms().add(room);
        return room;
    }
    public static List<Room> getAllRooms() {
        return hotel.getRooms();
    }
}