package service;

import api.repositories.RoomRepositoryInterface;
import api.services.RoomService;
import lombok.extern.slf4j.Slf4j;
import model.entity.RegistrationInfo;
import model.entity.Room;
import model.entity.fasility.Facility;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;
import repository.RoomRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Room> sortByComparator(Comparator<Room> comparator) {
            return roomRepository.getAll()
                    .stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
        }

    @Override
    public List<Room> sortFreeRoomByComparator(Comparator<Room> comparator) {
        return roomRepository.getAll()
                .stream().filter(room -> !room.isBusy())
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.getAll();
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
    public void addRoomService(Room room, Facility facility) {
        if (!room.getServices().contains(facility)){
            room.getServices().add(facility);
        }
    }

    public  List<Room> getFreeRooms(){
        return roomRepository.getAll().stream().
                filter(room -> !room.isBusy()).collect(Collectors.toList());
    }

}
