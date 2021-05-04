package model.enumType;

public enum ServiceType {
    CLEANING(30f),
    BREAKFAST(35f),
    DINNER(45f),
    FREE_WIFI(0f),
    SPA(120f);

    float price;

    public static ServiceType getByIndex(int index){ //роверка на графницы
        return ServiceType.values()[index];
    }

    ServiceType(float price) {
        this.price = price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "price=" + price +
                "} " + super.toString();
    }
}
