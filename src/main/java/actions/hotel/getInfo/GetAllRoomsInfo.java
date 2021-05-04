package actions.hotel.getInfo;

import actions.Action;
import controllers.RoomController;

public class GetAllRoomsInfo implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println(RoomController.getInstance().getAllRooms());
    }
}
