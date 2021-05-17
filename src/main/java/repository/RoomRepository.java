package repository;
import api.repositories.RoomRepositoryInterface;
import memoDataStorage.DataStorageRoom;
import model.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.MainServiceMethods;

import java.util.List;
import java.util.Optional;

@Component
public class RoomRepository extends MainRepositoryMethod<Room> implements RoomRepositoryInterface {

    @Autowired
    private static RoomRepository instance;

    public static RoomRepository getInstance() {
        if(instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }

    public void update(Room entity) {
        if(entity == null) throw new NullPointerException("");

        int index = DataStorageRoom.getAllRooms().indexOf(entity);
        DataStorageRoom.getAllRooms().set(index, entity);
    }

//    public Long create(Room entity) {
//        if(entity == null) throw new NullPointerException("");
//        return DataStorageRoom.createRoom(entity).getId();
//    }

    public void delete(Long id)  {

        Room heroToDelete = DataStorageRoom.getAllRooms()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(NullPointerException::new);

        DataStorageRoom.getAllRooms().remove(heroToDelete);
    }

    public Optional<Room> get(Long id) {

        if(id>= DataStorageRoom.getAllRooms().size())
            throw new IndexOutOfBoundsException(" Error!");

        return DataStorageRoom.getAllRooms()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Room> getAll() {
        return DataStorageRoom.getAllRooms();
    }


}
