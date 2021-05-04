package actions.hotel.changing;

import actions.Action;
import controllers.FacilityController;
import controllers.RoomController;
import factorymethod.FacilityFactory;
import model.entity.Room;
import model.entity.fasility.Facility;
import model.enumType.ServiceType;
import utils.ConsoleIn;

import java.util.ArrayList;
import java.util.List;

public class ChangeServiceRoom implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Enter Room ID to display");
        Long id = ConsoleIn.getScanner().nextLong();
        Room room = RoomController.getInstance().getRoom(id);

        System.out.println("Enter facility ID to display\n");

        Facility facility = FacilityController.getInstance().get(id);
        if(!room.getServices().contains(facility)) {
            room.getServices().add(facility);
        }

        RoomController.getInstance().update(room);
    }
}