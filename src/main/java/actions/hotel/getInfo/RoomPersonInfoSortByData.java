package actions.hotel.getInfo;
import actions.Action;
import controllers.RegistrationController;
import model.entity.RegistrationInfo;
import java.util.Comparator;
import java.util.List;

public class RoomPersonInfoSortByData implements Action {
    @Override
    public void execute() throws Exception {
        List<RegistrationInfo> info = RegistrationController.getInstance().getAllRegistrations();
        info.sort(Comparator.comparingLong(o -> o.getDataChekIn().getTimeInMillis()));
        System.out.println(info);
    }
}
