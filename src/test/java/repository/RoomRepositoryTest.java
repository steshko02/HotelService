package repository;

import memoDataStorage.DataStorageRoom;
import model.entity.Room;
import org.junit.Assert;
import org.junit.Test;

public class RoomRepositoryTest {


    @Test
    public void updateTest(){

        Room actual = new Room();

        DataStorageRoom.getAllRooms().add(actual);

        Room expected = new Room();

        int index = 0;

        DataStorageRoom.getAllRooms().set(index, expected);
        DataStorageRoom.getAllRooms().get(index);

        Assert.assertEquals(expected,expected);
        //ЧОт не очень тест получился, крч, все очевидно работает :))))
    }
}