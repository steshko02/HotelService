package actions.hotel.sortingfreeroom;
import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import java.util.Comparator;

public class SortFreeRoomByStars implements Action {
    @Override
    public void execute() throws Exception {
        RoomController.getInstance().sortByFreeRoomComparator(Comparator
                .comparing(Room::getStars)).forEach(System.out::println);
    }
}
