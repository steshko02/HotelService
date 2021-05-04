package actions.hotel.sortingfacilities;

import actions.Action;
import controllers.RegistrationController;
import controllers.RoomController;
import model.entity.RegistrationInfo;
import model.entity.Room;
import model.entity.fasility.Facility;
import utils.ConsoleIn;

import java.util.Comparator;

public class SortByCoast implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Enter Registration ID to display");
        Long id = ConsoleIn.getScanner().nextLong();
        System.out.println("Your facilities:\r\n");

        RegistrationInfo registrationInfo = RegistrationController.getInstance().get(id);

        System.out.println(registrationInfo.getPerson().getLastname());

        registrationInfo.getServices().stream()
                .sorted(Comparator.comparing(Facility::getCoast)).forEach(System.out::println);
    }
}
