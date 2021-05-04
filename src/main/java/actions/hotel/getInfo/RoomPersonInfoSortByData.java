package actions.hotel.getInfo;
import actions.Action;
import controllers.RegistrationController;
import controllers.RoomController;
import model.entity.RegistrationInfo;
import model.entity.Room;

import java.util.Comparator;
import java.util.List;

public class RoomPersonInfoSortByData implements Action {
    @Override
    public void execute() throws Exception {

        RegistrationController.getInstance().sortByComparator(Comparator
                .comparing(o -> o.getDataChekIn().getTimeInMillis()))
        .forEach(System.out::println);
    }
}
