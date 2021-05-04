package actions.hotel.changing;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import model.enumType.ServiceType;
import utils.ConsoleIn;

public class ChangeServiceRoom implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Enter Room ID to display");
        Long id = ConsoleIn.getScanner().nextLong();
        Room room = RoomController.getInstance().getRoom(id);

        System.out.println("Выберите услугу которую хотите добавить:" +
                "\n1-CLEANING" +
                "\n2-BREAKFAST" +
                "\n3-DINNER" +
                "\n4-FREE_WIFI" +
                "\n5-SPA");
        RoomController.getInstance().addRoomService(room, ServiceType.getByIndex(ConsoleIn.getScanner().nextInt() - 1));
        RoomController.getInstance().update(room);
    }
}
