package actions.hotel.changing;

import service.RoomServiceImp;
import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import model.enumType.StatusRoom;
import utils.ConsoleIn;

public class ChangeStatusRoom implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Enter Room ID to display");
        Long id = ConsoleIn.getScanner().nextLong();

        Room room = RoomController.getInstance().getRoom(id);

        System.out.println("1-REPAIRABLE\n" +
                "2-SERVICED\n" +
                "3-PREPARED\n" +
                "Состояние комнаты:" );
        RoomController.getInstance().changeNumberStatus(room,StatusRoom.getByIndex(ConsoleIn.getScanner().nextInt()-1));

        RoomController.getInstance().update(room);
    }
}
