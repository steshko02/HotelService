package service;

import api.repositories.RegistrationRepositoryInterface;
import api.services.RegistrationService;
import model.entity.RegistrationInfo;
import repository.RegistrationInfoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationServiceImp implements RegistrationService {

    private RegistrationRepositoryInterface registrationRepository;

    private static RegistrationServiceImp instance;

    private RegistrationServiceImp() {
        this.registrationRepository = RegistrationInfoRepository.getInstance();
    }

    public static RegistrationServiceImp getInstance() {
        if (instance == null) {
            instance = new RegistrationServiceImp();
        }
        return instance;
    }

    @Override
    public Long create(RegistrationInfo entity) {
        return registrationRepository.create(entity);
    }

    @Override
    public RegistrationInfo get(Long index) {
        return registrationRepository.get(index).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<RegistrationInfo> sortByComparator(Comparator<RegistrationInfo> comparator) {
        return registrationRepository.getAll()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        registrationRepository.delete(id);
    }

    @Override
    public void update(RegistrationInfo entity) {
        registrationRepository.update(entity);
    }

    @Override
    public List<RegistrationInfo> getAll() {
       return registrationRepository.getAll();
    }


}
