package service;

import api.repositories.FacilitiesRepositoryInterface;
import api.repositories.RegistrationRepositoryInterface;
import api.services.FacilityService;
import model.entity.RegistrationInfo;
import model.entity.fasility.Facility;
import repository.FacilitiesRepository;
import repository.RegistrationInfoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FacilityServiceImp implements FacilityService {

    private FacilitiesRepositoryInterface facilityRepository;

    private static FacilityServiceImp instance;

    private FacilityServiceImp() {
        this.facilityRepository = FacilitiesRepository.getInstance();
    }

    public static FacilityServiceImp getInstance() {
        if (instance == null) {
            instance = new FacilityServiceImp();
        }
        return instance;
    }

    @Override
    public Long create(Facility entity) {
        return facilityRepository.create(entity);
    }

    @Override
    public Facility get(Long index) {
        return facilityRepository.get(index).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<Facility> sortByComparator(Comparator<Facility> comparator) {
        return facilityRepository.getAll()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        facilityRepository.delete(id);
    }

    @Override
    public void update(Facility entity) {
        facilityRepository.update(entity);
    }

    @Override
    public List<Facility> getAll() {
        return facilityRepository.getAll();
    }

}
