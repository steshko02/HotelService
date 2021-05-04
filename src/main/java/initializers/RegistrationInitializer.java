package initializers;

import controllers.RegistrationController;
import controllers.RoomController;
import model.entity.Person;
import model.entity.RegistrationInfo;
import model.entity.Room;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;
import utils.ConsoleIn;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class RegistrationInitializer implements Initializer{
    @Override
    public void init() {

        RegistrationController.getInstance().createRegistrationInfo(
                0L,
                new Person("Andrey","Moshonkin","9ywd432fsdf2321"),
                new GregorianCalendar(2021, Calendar.MAY, 1,13,12,37),
                new GregorianCalendar(2021, Calendar.MAY, 2,10,0,0),
                new ArrayList<ServiceType>() {{
                    add(ServiceType.CLEANING);
                    add(ServiceType.DINNER);
                }},
                2,
                3610f
        );
        RegistrationController.getInstance().createRegistrationInfo(
                1L,
                new Person("Lena","Golovach","9d2ff2321"),
                new GregorianCalendar(2021, Calendar.MAY, 12,13,12,37),
                new GregorianCalendar(2021, Calendar.MAY, 21,10,0,0),
                new ArrayList<ServiceType>() {{
                    add(ServiceType.DINNER);
                }},
                3,
                4000f
        );
        RegistrationController.getInstance().createRegistrationInfo(
                2L,
                new Person("qqq","eeeeeeqweq","9d2fqweqwf2321"),
                new GregorianCalendar(2021, Calendar.MAY,1 ,15,12,37),
                new GregorianCalendar(2021, Calendar.MAY, 3,17,0,0),
                new ArrayList<ServiceType>() {{
                    add(ServiceType.DINNER);
                }},
                5,
                6000f
        );
        RegistrationController.getInstance().createRegistrationInfo(
                3L,
                new Person("dsfdsf","sdfsdfsdf","9d2ff33232321"),
                new GregorianCalendar(2021, Calendar.MAY, 4,12,12,37),
                new GregorianCalendar(2021, Calendar.MAY, 30,11,0,0),
                new ArrayList<ServiceType>() {{
                    add(ServiceType.DINNER);
                }},
                4,
                2000f
        );

    }

    public  static Person initPerson(){

        System.out.println("Введите имя фамилию:");
        String name = ConsoleIn.getScanner().next();
        String surname = ConsoleIn.getScanner().next();

        System.out.println("Паспортные данные: ");
        String passportDate = ConsoleIn.getScanner().next();
        return new Person(name,surname,passportDate);
    }

    public static List<ServiceType> initService(){

        List<ServiceType> serviceTypes = new ArrayList<>();
      //  do{
            System.out.println(
                    "1-CLEANING\n" + //в форич засунуть
                    "2-BREAKFAST\n" +
                    "3-DINNER\n" +
                    "4-FREE_WIFI\n" +
                    "5-SPA\n" +
                            "0-Exit");

            int command = ConsoleIn.getScanner().nextInt();
           serviceTypes.add(ServiceType.getByIndex(command));
      //  }
        //while ();
        return serviceTypes;
    }

    public static RegistrationInfo customRegistrationInit(){
        RegistrationInfo registrationInfo = new RegistrationInfo();
        System.out.println("Введите номер комнаты:");
        Long roomId = ConsoleIn.getScanner().nextLong();
        registrationInfo.setRoomId(roomId);
        registrationInfo.setPerson(initPerson());

        System.out.println("Введите кол-во дней: ");
        int days= ConsoleIn.getScanner().nextInt();

        Calendar dataChekOut= Calendar.getInstance();
        dataChekOut.add(Calendar.DAY_OF_MONTH,days);

        registrationInfo.setDataChekIn( Calendar.getInstance());
        registrationInfo.setDataChekOut(dataChekOut);

        System.out.println("Количество почетителей: ");
        int count = ConsoleIn.getScanner().nextInt();

        if(RoomController.getInstance().getRoom(roomId).getCapacity()<=count){
            System.out.println("Недостаточно мест в комнате.");
        }
        registrationInfo.setServices(initService());

        return registrationInfo;
    }
}
