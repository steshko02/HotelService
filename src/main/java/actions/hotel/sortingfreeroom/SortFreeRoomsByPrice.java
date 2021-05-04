package actions.hotel.sortingfreeroom;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class SortFreeRoomsByPrice implements Action {
    @Override
    public void execute() throws Exception {
        List<Room> freeRooms =  RoomController.getInstance().getFreeRooms();
        RoomController.getInstance().sortByPrice(freeRooms);
        System.out.println(freeRooms);
    }
}
