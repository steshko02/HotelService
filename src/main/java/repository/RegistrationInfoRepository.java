package repository;

import api.repositories.RegistrationRepositoryInterface;
import memoDataStorage.DataStorageRegistrationInfo;
import model.entity.RegistrationInfo;

import java.util.List;
import java.util.Optional;

public class RegistrationInfoRepository implements RegistrationRepositoryInterface {
    private static RegistrationInfoRepository instance;

    public static RegistrationInfoRepository getInstance() {
        if(instance == null) {
            instance = new RegistrationInfoRepository();
        }
        return instance;
    }

    @Override
    public void update(RegistrationInfo entity) {
        if(entity == null) throw new NullPointerException("");

        int index = DataStorageRegistrationInfo.getAllRegistrations().indexOf(entity);
        DataStorageRegistrationInfo.getAllRegistrations().set(index, entity);
    }

    @Override
    public Long create(RegistrationInfo entity) {
        if(entity == null) throw new NullPointerException("");
        return DataStorageRegistrationInfo.createRegistration(entity).getId();
    }

    @Override
    public void delete(Long id) {
        RegistrationInfo registrationInfoToDelete =
                DataStorageRegistrationInfo.getAllRegistrations()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(NullPointerException::new);

        DataStorageRegistrationInfo.getAllRegistrations().remove(registrationInfoToDelete);
    }

    @Override
    public Optional<RegistrationInfo> get(Long id) {
        if(id>=  DataStorageRegistrationInfo.getAllRegistrations().size())
            throw new IndexOutOfBoundsException(" Error!");

        return  DataStorageRegistrationInfo.getAllRegistrations()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<RegistrationInfo> getAll() {
        return  DataStorageRegistrationInfo.getAllRegistrations();
    }
}
