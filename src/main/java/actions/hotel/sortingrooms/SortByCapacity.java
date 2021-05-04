package actions.hotel.sortingrooms;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;

import java.util.Comparator;

public class SortByCapacity implements Action {
    @Override
    public void execute() throws Exception {
        RoomController.getInstance().sortByComparator(Comparator
                .comparing(Room::getCapacity)).forEach(System.out::println);
    }
}
