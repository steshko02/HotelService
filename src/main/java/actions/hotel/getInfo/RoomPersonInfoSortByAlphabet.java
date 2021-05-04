package actions.hotel.getInfo;
import actions.Action;
import controllers.RegistrationController;
import lombok.extern.slf4j.Slf4j;


import java.util.*;

@Slf4j
public class RoomPersonInfoSortByAlphabet implements Action {
    @Override
    public void execute() throws Exception {

        RegistrationController.getInstance().sortByComparator(Comparator
                .comparing(p -> p.getPerson().getLastname().toLowerCase(Locale.ROOT)))
                .forEach(System.out::println);
        }
}

