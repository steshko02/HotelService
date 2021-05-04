package initializers;

import controllers.RoomController;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;

import java.util.ArrayList;

public class RoomInitializer implements Initializer{
    @Override
    public void init() {
        RoomController.getInstance().createRoom(
                1000f,
                new ArrayList<>() ,
                StatusRoom.SERVICED,
                true,
                4,
                5
        );

        RoomController.getInstance().createRoom(
                600f,
                new ArrayList<>(),
                StatusRoom.SERVICED,
                true,
                5,
                3
        );

        RoomController.getInstance().createRoom(
                800f,
                new ArrayList<>() ,
                StatusRoom.SERVICED,
                true,
                2,
                4
        );
        RoomController.getInstance().createRoom(
                720f,
                new ArrayList<>() ,
                StatusRoom.SERVICED,
                true,
                5,
                4
        );
        RoomController.getInstance().createRoom(
                643f,
                new ArrayList<>() ,
                StatusRoom.SERVICED,
                false,
                3,
                4
        );
        RoomController.getInstance().createRoom(
                700f,
                new ArrayList<>() ,
                StatusRoom.SERVICED,
                false,
                5,
                4
        );
    }
}
