package api.repositories;

import model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface  AbstractRepository <T extends BaseEntity> {
    Long create(T entity);

    void delete(Long entity) throws NullPointerException;

    void update(T entity);

    Optional<T> get(Long id);

    List<T> getAll();
}
