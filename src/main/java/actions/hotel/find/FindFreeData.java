package actions.hotel.find;

import actions.Action;
import controllers.RegistrationController;
import controllers.RoomController;
import model.entity.RegistrationInfo;
import model.entity.Room;
import utils.ConsoleIn;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class FindFreeData implements Action {
    @Override
    public void execute() throws Exception {

        int month,day,hour;

        System.out.println("введите:\n месяц = ");
        month = ConsoleIn.getScanner().nextInt();
        System.out.println("\n день = ");
        day = ConsoleIn.getScanner().nextInt();
        System.out.println("\n час = ");
        hour = ConsoleIn.getScanner().nextInt();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(Year.now().getValue(), month-1,day,hour,0);
        System.out.println(dateFormat.format(calendar.getTime()));
        List<Room> result = new ArrayList<>(RoomController.getInstance().getFreeRooms());

        for (RegistrationInfo r: RegistrationController.getInstance().getAllRegistrations()) {
            if(calendar.after(r.getDataChekOut())){
                result.add(RoomController.getInstance().getRoom(r.getRoomId()));
            }
        }
//        RegistrationController.getInstance().getAllRegistrations().stream().
//                filter( a->calendar.after(a.getDataChekOut())).
//                collect(Collectors.toList()).
//                forEach(a->result.add(RoomController.getInstance().getRoom(a.getRoomId())));

        System.out.println(result);
    }
}
