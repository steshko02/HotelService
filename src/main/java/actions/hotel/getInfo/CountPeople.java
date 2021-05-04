package actions.hotel.getInfo;

import actions.Action;
import controllers.RegistrationController;
import model.entity.RegistrationInfo;

import java.util.List;

public class CountPeople implements Action {
    @Override
    public void execute() throws Exception {
        int count = 0;
       // registrations.stream().filter(RegistrationInfo::getCountPeople).forEach();
        //registrations.forEach(RegistrationInfo::getCountPeople);
        for (RegistrationInfo ri:RegistrationController.getInstance().getAllRegistrations()) {
            count+=ri.getCountPeople();
        }
        System.out.println(count);
    }
}
