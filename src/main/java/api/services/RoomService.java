package api.services;

import api.services.AbstractService;
import model.entity.Room;
import model.entity.fasility.Facility;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;

import java.util.Comparator;
import java.util.List;

public interface RoomService extends AbstractService<Room> {

     void PutInRoom(Room room);

     void evictFromRoom(Room room);

     List<Room> getAllRooms();

     void changeNumberStatus(Room room, StatusRoom status);

     void changePriceRoom(Room room,float price);

     void addRoomService(Room room, Facility type);

     List<Room> sortFreeRoomByComparator(Comparator<Room> comparator);

     List<Room> getFreeRooms();
}
