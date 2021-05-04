package actions.hotel.changing;

import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import repository.RoomRepository;
import utils.ConsoleIn;

public class ChangePriceRoom implements Action {
    @Override
    public void execute() throws Exception {
        System.out.println("Enter Room ID to display");
        Long id = ConsoleIn.getScanner().nextLong();
        Room room = RoomController.getInstance().getRoom(id);
        System.out.println("Введите цену для этого номера: ");
        float price=ConsoleIn.getScanner().nextFloat();
        RoomController.getInstance().changePriceRoom(room,price);
        RoomRepository.getInstance().update(room);
    }
}
