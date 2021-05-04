package actions.hotel.getInfo;

import actions.Action;
import controllers.RegistrationController;
import controllers.RoomController;
import model.entity.RegistrationInfo;
import model.entity.Room;
import utils.ConsoleIn;

public class GetFullCostByRoom implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Enter Registration ID to display");
        Long id = ConsoleIn.getScanner().nextLong();
        System.out.println("Your cost-info:\r\n");
        System.out.println(RegistrationController.getInstance().get(id).getFullCost());
    }
}
