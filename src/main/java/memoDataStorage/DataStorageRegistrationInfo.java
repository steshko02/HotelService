package memoDataStorage;

import model.entity.Hotel;
import model.entity.RegistrationInfo;
import model.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class DataStorageRegistrationInfo {
    private static Long registrations_id_sequence = 0L;
    private final static List<RegistrationInfo> registrations= new ArrayList<>();

    private static Long generateRegistrationId() {
        return registrations_id_sequence++;
    }

    public static RegistrationInfo createRegistration(RegistrationInfo registrationInfo) {
        registrationInfo.setId(generateRegistrationId());
        registrations.add(registrationInfo);
        return registrationInfo;
    }
    public static List<RegistrationInfo> getAllRegistrations() {
        return registrations;
    }
}
