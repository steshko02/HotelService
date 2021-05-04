package controllers;
import api.services.RegistrationService;
import model.entity.Person;
import model.entity.RegistrationInfo;
import model.entity.Room;
import model.enumType.ServiceType;
import service.RegistrationServiceImp;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.List;

public class RegistrationController {

    private RegistrationService registrationService;
    private static RegistrationController instance;

    public static RegistrationController getInstance() {
        if (instance == null) {
            instance = new RegistrationController();
        }
        return instance;
    }
    private RegistrationController() {
        this.registrationService = RegistrationServiceImp.getInstance();
    }

    public void createRegistrationInfo(Long roomId, Person person, Calendar dataChekIn,
                                       Calendar dataChekOut, List<ServiceType> services,
                                       int countPeople,float fullCost) {
        RegistrationInfo registrationInfo  = new RegistrationInfo(roomId,person,dataChekIn,dataChekOut,
                services, countPeople,fullCost);
        createRegistrationInfo(registrationInfo);
    }
    public Long createRegistrationInfo(RegistrationInfo entity) {
        return registrationService.create(entity);
    }
    public RegistrationInfo get(Long index) {
       return RegistrationServiceImp.getInstance().get(index);
    }

    public List<RegistrationInfo> getAllRegistrations(){
        return registrationService.getAll();
    }

    public void delete(Long id) { RegistrationServiceImp.getInstance().delete(id); }

    public void update(RegistrationInfo entity) {
        RegistrationServiceImp.getInstance().update(entity);
    }
}
