package model.enumType;

public enum ServiceType {
    CLEANING,
    BREAKFAST,
    DINNER,
    FREE_WIFI,
    SPA;

        public static ServiceType getByIndex(int index){
        return ServiceType.values()[index];
    }
}
//    float price;
//

//
//    ServiceType(float price) {
//        this.price = price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    @Override
//    public String toString() {
//        return "ServiceType{" +
//                "price=" + price +
//                "} " + super.toString();
//    }
//}
