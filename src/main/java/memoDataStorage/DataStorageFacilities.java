package memoDataStorage;

import model.entity.RegistrationInfo;
import model.entity.fasility.Facility;

import java.util.ArrayList;
import java.util.List;

public class DataStorageFacilities {
    private static Long facilities_id_sequence = 0L;
    private final static List<Facility> facilities= new ArrayList<>();

    private static Long generateFacilitiesId() {
        return facilities_id_sequence++;
    }

    public static Facility createFacility(Facility facility) {
        facility.setId(generateFacilitiesId());
        facilities.add(facility);
        return facility;
    }
    public static List<Facility> getAllFacilities() {
        return facilities;
    }
}
