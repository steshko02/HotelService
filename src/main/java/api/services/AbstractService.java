package api.services;

import api.repositories.RoomRepositoryInterface;
import model.entity.BaseEntity;

import java.util.Comparator;
import java.util.List;

public interface AbstractService <T extends BaseEntity> {

    Long create(T entity);

    void delete(Long id) throws NullPointerException;

    void update(T entity);

    T get(Long id) throws NullPointerException;

    List<T> sortByComparator(Comparator<T> comparator);

    List<T> getAll();
}
