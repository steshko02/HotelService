package actions.hotel.getInfo;

import actions.Action;
import controllers.RegistrationController;
import model.entity.RegistrationInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LastPeopleInfo implements Action {
    @Override
    public void execute() throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        int lastElement=RegistrationController.getInstance().getAllRegistrations().size()-1;

        for (int i = lastElement;i>lastElement-3 && i>=0;i--) {

            System.out.println(
                    RegistrationController.getInstance().getAllRegistrations().get(i).getPerson() +" "+
                            dateFormat.format(RegistrationController.getInstance().
                                    getAllRegistrations().get(i).getDataChekIn().getTime())+ " - "
                            + dateFormat.format(RegistrationController.getInstance().
                            getAllRegistrations().get(i).getDataChekOut().getTime())
            );
        }
    }
}
