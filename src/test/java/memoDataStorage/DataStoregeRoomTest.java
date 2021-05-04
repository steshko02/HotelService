package memoDataStorage;

import model.entity.Room;
import org.junit.Assert;
import org.junit.Test;

public class DataStoregeRoomTest {

    @Test
    public void createHeroTest(){

        Room actual = new Room();

        actual.setId(0L);

        Room expected = new Room();

        DataStorageRoom.createRoom(expected);

        Assert.assertEquals(actual,expected);
    }

}