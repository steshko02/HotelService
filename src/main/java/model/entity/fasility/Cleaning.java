package model.entity.fasility;

public class Cleaning extends Facility {
    private float coast;

    public Cleaning(float coast) {
        this.coast = coast;
    }

    @Override
    public float getCoast() {
        return coast;
    }

    @Override
    public void setCoast(float coast) {
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "Cleaning coast=" + coast ;
    }
}
