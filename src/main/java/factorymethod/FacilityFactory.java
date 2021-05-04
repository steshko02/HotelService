package factorymethod;

import lombok.extern.slf4j.Slf4j;
import model.entity.fasility.*;
import model.enumType.ServiceType;
@Slf4j
public class FacilityFactory {

    public static Facility create(ServiceType service,float coast){

        switch (service) {
            case BREAKFAST:
                return  new Breakfast(coast);
            case DINNER:
                return new Dinner(coast);
            case FREE_WIFI:
                return new FreeWiFi(coast);
            case CLEANING:
                return new Cleaning(coast);
            case SPA:
                return new SPA(coast);
            default:
                log.info("illegal argument");
                return null;
        }
    }
}
