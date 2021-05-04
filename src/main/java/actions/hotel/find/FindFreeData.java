package actions.hotel.find;

import actions.Action;
import controllers.RegistrationController;
import controllers.RoomController;
import model.entity.RegistrationInfo;
import model.entity.Room;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FindFreeData implements Action {
    @Override
    public void execute() throws Exception {

        Calendar calendar = new GregorianCalendar();
        List<RegistrationInfo> registrationInfoList = RegistrationController.getInstance().getAllRegistrations();
        List<RegistrationInfo> noActiveInTheFuture =new ArrayList<>();
        List<Room> rooms = RoomController.getInstance().getFreeRooms();
        List<Room> result = new ArrayList<>(rooms);

       registrationInfoList.stream().filter(a->a.getDataChekOut().before(calendar))
               .forEach(noActiveInTheFuture::add);

        noActiveInTheFuture.forEach(a->result.add(RoomController.getInstance().getRoom(a.getRoomId())));

        System.out.println(result);
    }
}
