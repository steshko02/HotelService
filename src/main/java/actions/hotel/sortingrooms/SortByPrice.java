package actions.hotel.sortingrooms;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;

import java.util.Comparator;
import java.util.List;

public class SortByPrice implements Action {
    @Override
    public void execute() throws Exception {
        RoomController.getInstance().sortByComparator(Comparator
                .comparing(Room::getPriceRoom)).forEach(System.out::println);
    }
}
