package model.entity.fasility;

public class Dinner extends Facility {
    private float coast;

    @Override
    public float getCoast() {
        return coast;
    }

    @Override
    public void setCoast(float coast) {
        this.coast = coast;
    }

    public Dinner(float coast) {
        this.coast = coast;
    }
    @Override
    public String toString() {
        return "Dinner coast=" + coast ;
    }
}
