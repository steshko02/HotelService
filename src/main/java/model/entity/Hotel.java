package model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Hotel extends BaseEntity{
    private final int MAX_COUNT_ROOM =20;
    private List<Room> rooms;
//    private int countRooms;

    public Hotel(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Hotel() {


    }
}
