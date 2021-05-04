package repository;

import api.repositories.FacilitiesRepositoryInterface;
import memoDataStorage.DataStorageFacilities;
import memoDataStorage.DataStorageRegistrationInfo;
import model.entity.RegistrationInfo;
import model.entity.fasility.Facility;

import java.util.List;
import java.util.Optional;

public class FacilitiesRepository implements FacilitiesRepositoryInterface {
    private static FacilitiesRepository instance;

    public static FacilitiesRepository getInstance() {
        if(instance == null) {
            instance = new FacilitiesRepository();
        }
        return instance;
    }

    @Override
    public void update(Facility entity) {
        if(entity == null) throw new NullPointerException("");

        int index = DataStorageFacilities.getAllFacilities().indexOf(entity);
        DataStorageFacilities.getAllFacilities().set(index, entity);
    }

    @Override
    public Long create(Facility entity) {
        if(entity == null) throw new NullPointerException("");
        return DataStorageFacilities.createFacility(entity).getId();
    }

    @Override
    public void delete(Long id) {
        Facility facility =
                DataStorageFacilities.getAllFacilities()
                        .stream()
                        .filter(e -> e.getId().equals(id))
                        .findFirst()
                        .orElseThrow(NullPointerException::new);

        DataStorageFacilities.getAllFacilities().remove(facility);
    }

    @Override
    public Optional<Facility> get(Long id) {
        if(id>=  DataStorageRegistrationInfo.getAllRegistrations().size())
            throw new IndexOutOfBoundsException(" Error!");

        return  DataStorageFacilities.getAllFacilities()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Facility> getAll() {
        return  DataStorageFacilities.getAllFacilities();
    }
}
