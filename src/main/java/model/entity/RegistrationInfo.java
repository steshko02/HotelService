package model.entity;

import lombok.EqualsAndHashCode;
import model.enumType.ServiceType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@lombok.Data
public class RegistrationInfo extends BaseEntity {
    private Long roomId;
    private Person person;
    private Calendar dataChekIn;
    private Calendar  dataChekOut;
    private List<ServiceType> services;
    private int countPeople;
    private Long id;  //Base
    private float fullCost;


    public RegistrationInfo(Long roomId, Person person, Calendar dataChekIn,
                            Calendar dataChekOut, List<ServiceType> services, int countPeople, float fullCost) {
        this.roomId = roomId;
        this.person = person;
        this.dataChekIn = dataChekIn;
        this.dataChekOut = dataChekOut;
        this.services = services;
        this.countPeople = countPeople;
        this.fullCost = fullCost;
    }

    public RegistrationInfo() {

    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return
                "roomId=" + roomId +"\n"+
                " person=" + person +"\n"+
                " dataChekIn=" + dateFormat.format(dataChekIn.getTime()) +"\n"+
                " dataChekOut=" + dateFormat.format(dataChekOut.getTime()) +"\n"+
                " services=" + services +"\n"+
                " countPeople=" + countPeople +"\n"+
                " id=" + id +"\n"+
                        super.toString();
    }
}
