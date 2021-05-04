package actions.hotel.peopleOperarion;

import controllers.RegistrationController;
import initializers.RegistrationInitializer;
import lombok.extern.slf4j.Slf4j;
import model.entity.RegistrationInfo;
import model.enumType.StatusRoom;
import service.RoomServiceImp;
import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import utils.ConsoleIn;
@Slf4j
public class SetPeopleInRoom implements Action {
    @Override
    public void execute() throws Exception {

        RegistrationInfo registrationInfo = RegistrationInitializer.customRegistrationInit();

        Room room = RoomController.getInstance().getRoom(registrationInfo.getRoomId());

        if(room.getStatusRoom().equals(StatusRoom.PREPARED)
                || room.getCapacity()<=registrationInfo.getCountPeople()) {

            RoomController.getInstance().PutInRoom(room);

            RegistrationController.getInstance().createRegistrationInfo(registrationInfo);

            log.info("Now room is serviced");
        }
        else
            log.info("Room is not ready or does no fit");
        RoomController.getInstance().update(room);
    }
}
