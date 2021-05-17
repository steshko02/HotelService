package repository;

import api.repositories.AbstractRepository;
import model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public abstract class MainRepositoryMethod <T extends BaseEntity> implements AbstractRepository<T> {
    @Override
    public Long create(T entity){
        System.out.println("PZDC");
        return 0L;
    }
    @Override
    public void delete(Long entity) throws NullPointerException{

    }
    @Override
    public void update(T entity){

    };
    @Override
    public Optional<T> get(Long id){
        return Optional.empty();
    }
    @Override
    public List<T> getAll(){
        return null;
    }
}
