package initializers;

import controllers.FacilityController;
import controllers.RegistrationController;
import controllers.RoomController;
import model.entity.Person;
import model.entity.RegistrationInfo;
import model.entity.fasility.*;
import utils.ConsoleIn;

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
                new GregorianCalendar(2021, Calendar.MAY, 4,13,12,37),
                new GregorianCalendar(2021, Calendar.MAY, 8,10,0,0),
                new ArrayList<Facility>() {{
                    add(new Dinner(100f));
                    add(new Cleaning(200f));
                }},
                2,
                3610f
        );
        RegistrationController.getInstance().createRegistrationInfo(
                1L,
                new Person("Lena","Golovach","9d2ff2321"),
                new GregorianCalendar(2021, Calendar.MAY, 2,13,12,37),
                new GregorianCalendar(2021, Calendar.MAY, 12,10,0,0),
                new ArrayList<Facility>() {{
                    add(new Breakfast(100f));
                    add(new Cleaning(200f));
                }},
                3,
                4000f
        );
        RegistrationController.getInstance().createRegistrationInfo(
                2L,
                new Person("qqq","eeeeeeqweq","9d2fqweqwf2321"),
                new GregorianCalendar(2021, Calendar.MAY,1 ,15,12,37),
                new GregorianCalendar(2021, Calendar.MAY, 7,17,0,0),
                new ArrayList<Facility>() {{
                    add(new FreeWiFi(0f));
                }},
                5,
                6000f
        );
        RegistrationController.getInstance().createRegistrationInfo(
                3L,
                new Person("dsfdsf","sdfsdfsdf","9d2ff33232321"),
                new GregorianCalendar(2021, Calendar.MAY, 3,12,12,37),
                new GregorianCalendar(2021, Calendar.MAY, 19,11,0,0),
                new ArrayList<Facility>() {{
                    add(new Cleaning(100f));
                    add(new Breakfast(300f));
                    add(new SPA(30f));
                    add(new FreeWiFi(0f));
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

    public static List<Facility> initService(){

        List<Facility> services = new ArrayList<>();
        long id;
        boolean exit=false;
        do{
            try {
                System.out.println("Enter facilities ID to display\n" +
                        "Esc for exit");
                id = ConsoleIn.getScanner().nextLong();
                Facility facility =FacilityController.getInstance().get(id);
                if(!services.contains(facility)) {
                    services.add(facility);
                }
            }
            catch (IllegalArgumentException e){
                exit=true;
            }
       } while (exit);
        return services;
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
        }else {
            registrationInfo.setCountPeople(count);
        }
        registrationInfo.setServices(initService());

        return registrationInfo;
    }
}
