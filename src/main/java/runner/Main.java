package runner;

import actions.Action;
import actions.ActionExecute;
import actions.hotel.find.FindFreeData;
import actions.hotel.getInfo.*;
import actions.hotel.peopleOperarion.SetPeopleInRoom;
import actions.hotel.sortingfreeroom.SortFreeRoomByCapacity;
import actions.hotel.sortingfreeroom.SortFreeRoomsByPrice;
import controllers.RegistrationController;
import initializers.Initializer;
import initializers.RegistrationInitializer;
import initializers.RoomInitializer;
import java.util.Arrays;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Initializer> initializers = Arrays.asList(
                new RoomInitializer(),
                new RegistrationInitializer()
        );

        initializers.forEach(Initializer::init);


//        //System.out.println(RegistrationController.getInstance().getAllRegistrations());
        //ActionExecute.execute(new SetPeopleInRoom());
    //    ActionExecute.execute(new LastPeopleInfo());
      //  ActionExecute.execute(new RoomPersonInfoSortByData());
      //  System.out.println("======================================");
       // System.out.println(RegistrationController.getInstance().getAllRegistrations());
       // System.out.println(RegistrationController.getInstance().getAllRegistrations());
//       // ActionExecute.execute(new GetRoomInfo());
//        ActionExecute.execute(new GetAllRoomsInfo());
//       //ActionExecute.execute(new SetPeopleInRoom());
//       // ActionExecute.execute(new SortbyStars());
////        ActionExecute.execute(new GetRoomInfo());
//        ActionExecute.execute(new SortFreeRoomsByPrice());
//        ActionExecute.execute(new GetAllRoomsInfo());
//   //     ActionExecute.execute(new EvictFromRoom());
//
//    //    ActionExecute.execute(new ChangeStatusRoom());
//
//   //     ActionExecute.execute(new CreateNewRoom());
//    //    ActionExecute.execute(new ChangePriceRoom());
//    //    ActionExecute.execute(new ChangeServiceRoom())
//      //  ActionExecute.execute(new GetRoomInfo());


        //ActionExecute.execute(new RoomPersonInfoSortByData());
        ActionExecute.execute(new FindFreeData());
      //  ActionExecute.execute(new GetAllRoomsInfo());
    }
}
