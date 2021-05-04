package controllers;

import api.services.FacilityService;
import model.entity.RegistrationInfo;
import model.entity.fasility.Facility;
import service.FacilityServiceImp;
import service.RegistrationServiceImp;

import java.util.Comparator;
import java.util.List;

public class FacilityController {

    private FacilityService facilityService;
    private static FacilityController instance;

    public static FacilityController getInstance() {
        if (instance == null) {
            instance = new FacilityController();
        }
        return instance;
    }
    private FacilityController() {
        this.facilityService = FacilityServiceImp.getInstance();
    }
    public Long createFacility(Facility entity) {
        return facilityService.create(entity);
    }

    public Facility get(Long index) {
        return FacilityServiceImp.getInstance().get(index);
    }

    public List<Facility> getAll(){
        return facilityService.getAll();
    }

    public void delete(Long id) {
        RegistrationServiceImp.getInstance().delete(id);
    }

    public void update(Facility entity) {
        FacilityServiceImp.getInstance().update(entity);
    }

    public List<Facility> sortByComparator(Comparator<Facility> comparator){
        return facilityService.sortByComparator(comparator);
    }
}
