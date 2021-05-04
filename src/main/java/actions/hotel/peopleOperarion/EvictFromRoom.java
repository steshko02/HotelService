package actions.hotel.peopleOperarion;

import controllers.RegistrationController;
import lombok.extern.slf4j.Slf4j;
import model.entity.RegistrationInfo;
import service.RoomServiceImp;
import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import repository.RoomRepository;
import utils.ConsoleIn;

import java.util.ArrayList;

@Slf4j
public class EvictFromRoom implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Введите номер запроса по которому хотите выселить");
        Long id = ConsoleIn.getScanner().nextLong();

        Room room = RoomController.getInstance().getRoom(RegistrationController.getInstance().get(id).getRoomId());
        RoomController.getInstance().evictFromRoom(room);
        room.setServices(new ArrayList<>());
        RoomController.getInstance().update(room);

        RegistrationController.getInstance().delete(id);
        log.info("успешно выселен");
    }

}
