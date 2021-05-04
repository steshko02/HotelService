package service;

import model.entity.Room;
import model.enumType.StatusRoom;
import org.junit.Assert;
import org.junit.Test;

public class RoomServiceTest {

    @Test
    public void PutInRoomTest(){

        Room actual = new Room();
        Room expected = new Room();
        expected.setBusy(false);
        actual.setBusy(true);

        RoomServiceImp.getInstance().PutInRoom(expected);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void evictFromRoomTest(){

        Room actual = new Room();
        actual.setBusy(false);
        Room expected = new Room();
        expected.setBusy(true);

        RoomServiceImp.getInstance().evictFromRoom(expected);

        Assert.assertEquals(actual,expected);
    }


    @Test
    public void changeNumberStatusTest (){

        Room actual = new Room();
        actual.setStatusRoom(StatusRoom.SERVICED);

        Room expected = new Room();
        expected.setServices(null);

        RoomServiceImp.getInstance().changeNumberStatus(expected, StatusRoom.SERVICED);

        Assert.assertEquals(actual,expected);
    }
}