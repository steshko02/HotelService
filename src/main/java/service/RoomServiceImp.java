package service;

import api.repositories.RoomRepositoryInterface;
import api.services.RoomService;
import lombok.extern.slf4j.Slf4j;
import model.entity.Room;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;
import repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class RoomServiceImp implements RoomService {

    private RoomRepositoryInterface roomRepository;
    private static RoomServiceImp instance;

    private RoomServiceImp() {
        this.roomRepository = RoomRepository.getInstance();
    }

    public static RoomServiceImp getInstance() {
        if (instance == null) {
            instance = new RoomServiceImp();
        }
        return instance;
    }
    public Long create(Room entity) {
        return roomRepository.create(entity);
    }

    public Room get(Long index) {
        return roomRepository.get(index).orElseThrow(NullPointerException::new);
    }

    public void delete(Long id) {
        roomRepository.delete(id);
    }

    public void update(Room entity) {
        roomRepository.update(entity);
    }

    public List<Room> getAllRooms(){
        return roomRepository.getAll();
    }

    public void PutInRoom(Room room) {
        if (room.isBusy()) return;
        room.setBusy(true);
        room.setStatusRoom(StatusRoom.SERVICED);
    }

    public void evictFromRoom(Room room) {
        if (room.isBusy()) {
            room.setBusy(false);
        }
    }

    public  void changeNumberStatus(Room room, StatusRoom status) {
           room.setStatusRoom(status);
    }

    @Override
    public void changePriceRoom(Room room, float price) {
        room.setPriceRoom(price);
    }

    @Override
    public void addRoomService(Room room, ServiceType type) {
        if (!room.getServices().contains(type)){
            room.getServices().add(type);
        }
    }

    public void sortByPrice(List<Room> rooms) {
        if (rooms == null) {
            log.error("expected not null object");
            throw new NullPointerException("object is null");
        }
        rooms.sort((o1, o2) -> Float.compare(o1.getPriceRoom(), o2.getPriceRoom()));
        log.info("sortByPrice has finished sorting...");
    }

    public void sortByCapacity(List<Room> rooms) {
        if (rooms == null) {
            log.error("expected not null object");
            throw new NullPointerException("object is null");
        }
        rooms.sort((o1, o2) -> Float.compare(o1.getCapacity(), o2.getCapacity()));
        log.info("sortByCapacity has finished sorting...");
    }
    public void sortByStars(List<Room> rooms) {
        if (rooms == null) {
            log.error("expected not null object");
            throw new NullPointerException("object is null");
        }
        rooms.sort((o1, o2) -> Float.compare(o1.getStars(), o2.getStars()));
        log.info("sortByStars has finished sorting...");
    }

    public  List<Room> getFreeRooms(){
        List<Room>  rooms = roomRepository.getAll();
        List<Room> freeRooms = new ArrayList<>();
        rooms.stream().filter(room -> !room.isBusy()).forEach(freeRooms::add);
        return freeRooms;
    }

}
