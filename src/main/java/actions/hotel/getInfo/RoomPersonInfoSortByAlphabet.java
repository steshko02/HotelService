package actions.hotel.getInfo;

import actions.Action;
import controllers.RegistrationController;
import controllers.RoomController;
import lombok.extern.slf4j.Slf4j;
import model.entity.RegistrationInfo;
import model.entity.Room;

import java.util.*;

@Slf4j
public class RoomPersonInfoSortByAlphabet implements Action {
    @Override
    public void execute() throws Exception {
        List<RegistrationInfo> info = RegistrationController.getInstance().getAllRegistrations();

        info.sort(Comparator.comparing(p -> p.getPerson().getLastname().toLowerCase(Locale.ROOT)));

        System.out.println(info);
        }
}

