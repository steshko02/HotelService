package model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Person extends BaseEntity{
    private String  firstname;
    private String  lastname;
    private String  passportNumber;

    public Person(String firstname, String lastname, String passportNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return
                "firstname=" + firstname + "\n"+
                " lastname=" + lastname + "\n"+
                " passportNumber=" + passportNumber ;
    }
}
