package actions.hotel.create;
import actions.Action;
import controllers.RoomController;
import model.entity.Room;
import model.enumType.StatusRoom;
import utils.ConsoleIn;
import java.util.ArrayList;

public class CreateNewRoom implements Action {
    @Override
    public void execute() {

        Room room = new Room();
        System.out.println("Price:");
        room.setPriceRoom(ConsoleIn.getScanner().nextFloat());

        System.out.println("1-REPAIRABLE\n" +
                "2-SERVICED\n" +
                "3-PREPARED\n" +
                "Состояние комнаты:" );
        room.setStatusRoom(StatusRoom.getByIndex(ConsoleIn.getScanner().nextInt()-1));


        System.out.println("Заселен ли номер?" +
                "1-да\n" +
                "0-нет\n");

        int tr= ConsoleIn.getScanner().nextInt();

        room.setBusy(tr!=0);

        room.setServices(new ArrayList<>());

        RoomController.getInstance().createRoom(room.getPriceRoom(),
                room.getServices(),room.getStatusRoom(),room.isBusy(),
                room.getCapacity(),room.getStars());
    }
}