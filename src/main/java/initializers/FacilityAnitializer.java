package initializers;
import controllers.FacilityController;
import factorymethod.FacilityFactory;
import model.enumType.ServiceType;


public class FacilityAnitializer  implements Initializer{
    @Override
    public void init() {
        FacilityController.getInstance().createFacility(
                FacilityFactory.create(ServiceType.CLEANING,120f)
        );
        FacilityController.getInstance().createFacility(
                FacilityFactory.create(ServiceType.SPA,150f)
        );
        FacilityController.getInstance().createFacility(
                FacilityFactory.create(ServiceType.BREAKFAST,180f)
        );
        FacilityController.getInstance().createFacility(
                FacilityFactory.create(ServiceType.DINNER,170f)
        );
        FacilityController.getInstance().createFacility(
                FacilityFactory.create(ServiceType.FREE_WIFI,0)
        );
    }
}
