package model.entity.fasility;

public class Breakfast extends Facility {
    private float coast;

    @Override
    public float getCoast() {
        return coast;
    }

    @Override
    public void setCoast(float coast) {
        this.coast = coast;
    }

    public Breakfast(float coast) {
        this.coast = coast;
    }
    @Override
    public String toString() {
        return "Breakfast coast= " + coast ;
    }
}
