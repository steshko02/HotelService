package service;

import api.repositories.AbstractRepository;
import api.services.AbstractService;
import model.entity.BaseEntity;
import repository.MainRepositoryMethod;

import java.util.List;
import java.util.Optional;

public abstract class MainServiceMethods <T extends BaseEntity> implements AbstractService<T> {

    private AbstractRepository<T> repository = new MainRepositoryMethod<T>() {
    };


    public AbstractRepository<T> getRepository() {
        return repository;
    }

    public void setRepository(AbstractRepository<T> repository) {
        this.repository = repository;
    }

    public Long create(T entity) {
        return repository.create(entity);
    }

    public T get(Long index) {
        return (T) repository.get(index).orElseThrow(NullPointerException::new);
    }
}

