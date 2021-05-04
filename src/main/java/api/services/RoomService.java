package api.services;

import api.services.AbstractService;
import model.entity.Room;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;

import java.util.List;

public interface RoomService extends AbstractService<Room> {
     Long create(Room entity);

     Room get(Long index) ;

     void delete(Long id) ;

     void update(Room entity) ;

     void PutInRoom(Room room);

     void evictFromRoom(Room room);

     List<Room> getAllRooms();

     void changeNumberStatus(Room room, StatusRoom status);

     void changePriceRoom(Room room,float price);

     void addRoomService(Room room,ServiceType type);

     void sortByPrice(List<Room> rooms);

     void sortByCapacity(List<Room> rooms);

     void sortByStars(List<Room> rooms);

     List<Room> getFreeRooms();
}
