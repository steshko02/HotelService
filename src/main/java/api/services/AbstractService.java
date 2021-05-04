package api.services;

import model.entity.BaseEntity;

public interface AbstractService <T extends BaseEntity> {
    Long create(T entity);

    void delete(Long id) throws NullPointerException;

    void update(T entity);

    T get(Long id) throws NullPointerException;

}
