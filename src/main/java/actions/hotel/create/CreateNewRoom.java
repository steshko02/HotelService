package actions.hotel.create;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;
import utils.ConsoleIn;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateNewRoom implements Action {
    @Override
    public void execute() {

        Room room = new Room();
        System.out.println("Price:");
        room.setPriceRoom(ConsoleIn.getScanner().nextFloat());

        System.out.println("1-REPAIRABLE\n" +
                "2-SERVICED\n" +
                "3-PREPARED\n" +
                "Состояние комнаты:" );
        room.setStatusRoom(StatusRoom.getByIndex(ConsoleIn.getScanner().nextInt()-1));


        System.out.println("Заселен ли номер?" +
                "1-да\n" +
                "0-нет\n");

        int tr= ConsoleIn.getScanner().nextInt();

        room.setBusy(tr!=0); //сделали для примера

        System.out.println("1-CLEANING" + //в форич засунуть
                "2-BREAKFAST\n" +
                "3-DINNER\n" +
                "4-FREE_WIFI\n" +
                "5-SPA\n" +
                "Услуги номера:" );
        room.setServices(new ArrayList<ServiceType>(){{
                add(ServiceType.getByIndex(ConsoleIn.getScanner().nextInt()-1));
        }});

        RoomController.getInstance().createRoom(room.getPriceRoom(),
                room.getServices(),room.getStatusRoom(),room.isBusy(),
                room.getCapacity(),room.getStars());
        //RoomController.getInstance().createRoom(room);
    }
}