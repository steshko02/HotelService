package model.entity.fasility;

public class SPA extends Facility {
    private float coast;

    @Override
    public float getCoast() {
        return this.coast;
    }

    @Override
    public void setCoast(float coast) {
        this.coast=coast;
    }

    public SPA(float coast) {
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "SPA coast=" + coast ;
    }
}
