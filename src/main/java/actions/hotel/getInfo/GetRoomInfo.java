package actions.hotel.getInfo;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import utils.ConsoleIn;

import java.util.Scanner;

public class GetRoomInfo implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Enter Room ID to display");
        Long id = ConsoleIn.getScanner().nextLong();
        Room room = RoomController.getInstance().getRoom(id);
        System.out.println("Your Room info:\r\n");
        System.out.println(room);
    }
}
