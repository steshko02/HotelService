package api.services;

import api.services.AbstractService;
import model.entity.RegistrationInfo;

import java.util.List;

public interface RegistrationService extends AbstractService<RegistrationInfo> {
    Long create(RegistrationInfo entity);

    RegistrationInfo get(Long index) ;

    void delete(Long id) ;

    void update(RegistrationInfo entity);

    List<RegistrationInfo> getAll();
}
