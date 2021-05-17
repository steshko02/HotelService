package actions.hotel.getInfo;

import actions.Action;
import controllers.FacilityController;
import controllers.RegistrationController;
import model.entity.fasility.Facility;

import java.util.Comparator;

public class GetFacilitiesInfoByPrice implements Action {
    @Override
    public void execute() throws Exception {
        FacilityController.getInstance().sortByComparator(Comparator
                .comparing(Facility::getCoast)).forEach(System.out::println);
    }
}
