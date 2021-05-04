package api.repositories;

import api.repositories.AbstractRepository;
import model.entity.RegistrationInfo;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepositoryInterface  extends AbstractRepository<RegistrationInfo> {
    void update(RegistrationInfo entity);
    Long create(RegistrationInfo entity);
    void delete(Long id);
    Optional<RegistrationInfo> get(Long id);
    List<RegistrationInfo> getAll();
}

