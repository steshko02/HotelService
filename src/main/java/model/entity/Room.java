package model.entity;

import lombok.EqualsAndHashCode;
import model.entity.fasility.Facility;
import model.enumType.ServiceType;
import model.enumType.StatusRoom;
import lombok.Data;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Room extends BaseEntity {
    private float priceRoom;
    private List<Facility> services;
    private StatusRoom statusRoom;
    private boolean isBusy;
    private Long id;
    private int capacity;
    private int stars;

    public Room(float priceRoom, List<Facility> services, StatusRoom statusRoom, boolean isBusy,
                int capacity,int stars) {
        this.priceRoom = priceRoom;
        this.services = services;
        this.statusRoom = statusRoom;
        this.isBusy = isBusy;
        this.capacity = capacity;
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Room{" +
                "priceRoom=" + priceRoom +
                ", services=" + services +
                ", statusRoom=" + statusRoom +
                ", isBusy=" + isBusy +
                ", index=" + id +
                ", capacity=" + capacity +
                ", stars=" + stars +
                '}';
    }
    public Room() {
    }
}