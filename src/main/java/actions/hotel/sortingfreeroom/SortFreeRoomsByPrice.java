package actions.hotel.sortingfreeroom;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortFreeRoomsByPrice implements Action {
    @Override
    public void execute() throws Exception {
        RoomController.getInstance().sortByFreeRoomComparator(Comparator
                .comparing(Room::getPriceRoom)).forEach(System.out::println);
    }
}
