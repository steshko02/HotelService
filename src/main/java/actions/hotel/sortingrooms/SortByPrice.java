package actions.hotel.sortingrooms;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;

import java.util.List;

public class SortByPrice implements Action {
    @Override
    public void execute() throws Exception {
        List<Room> rooms = RoomController.getInstance().getAllRooms();

        RoomController.getInstance().sortByPrice(rooms);
    }
}