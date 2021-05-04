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
@Slf4j
public class EvictFromRoom implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Введите номер запроса по которому хотите выселить");
        Long id = ConsoleIn.getScanner().nextLong();

        RegistrationInfo registrationInfo = RegistrationController.getInstance().get(id);

        Room room = RoomController.getInstance().getRoom(registrationInfo.getRoomId());
        RoomController.getInstance().evictFromRoom(room);
        RoomController.getInstance().update(room);

        RegistrationController.getInstance().delete(id);
        log.info("успешно выселен");
    }

}
