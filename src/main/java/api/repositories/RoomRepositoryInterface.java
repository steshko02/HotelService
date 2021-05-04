package api.repositories;

import api.repositories.AbstractRepository;
import model.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepositoryInterface extends AbstractRepository<Room> {
    void update(Room entity);
    Long create(Room entity);
    void delete(Long id);
    Optional<Room> get(Long id);
    List<Room> getAll();
}
