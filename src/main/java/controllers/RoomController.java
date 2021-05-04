package controllers;

import api.services.RoomService;
import service.*;
import model.entity.Room;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;

import java.util.List;

public class RoomController {

    private RoomService roomService;
    private static RoomController instance;

    private RoomController() {
        this.roomService = RoomServiceImp.getInstance();
    }

    public static RoomController getInstance() {
        if (instance == null) {
            instance = new RoomController();
        }
        return instance;
    }
    public void createRoom(float price, List<ServiceType> services, StatusRoom statusRoom,
                           boolean isBusy,int capacity,int stars) {
        Room room = new Room(price, services, statusRoom, isBusy,capacity,stars);
        createRoom(room);
    }
    private Long createRoom(Room room) {
        return roomService.create(room);
    }

    public Room getRoom(Long id) {
        return roomService.get(id);

    }

    public void update(Room room) {
        roomService.update(room);
    }

    public void deleteRoom(Long id) {
        roomService.delete(id);
    }

    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    public void PutInRoom(Room room) {
        roomService.PutInRoom(room);
    }

    public void evictFromRoom(Room room){
        roomService.evictFromRoom(room);
    }

    public  void changeNumberStatus(Room room, StatusRoom status) {
        roomService.changeNumberStatus( room,status);
    }

    public void changePriceRoom(Room room,float price){
        roomService.changePriceRoom(room,price);
    }

    public void addRoomService(Room room,ServiceType type){
        roomService.addRoomService(room,type);
    }

    public void sortByPrice(List<Room> rooms) {
        roomService.sortByPrice(rooms);
    }

    public void sortByCapacity(List<Room> rooms) {
        roomService.sortByCapacity(rooms);
    }

    public void sortByStars(List<Room> rooms) {
        roomService.sortByStars(rooms);
    }

    public List<Room> getFreeRooms(){
        return roomService.getFreeRooms();
    }



}
