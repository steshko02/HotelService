package actions.hotel.sortingrooms;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;

import java.util.Comparator;
import java.util.List;

public class SortByStars implements Action {
    @Override
    public void execute() throws Exception {
        RoomController.getInstance().sortByComparator(Comparator
                .comparing(Room::getStars)).forEach(System.out::println);
    }
}
