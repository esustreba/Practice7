package ua.nure.strebkov.SummaryTask3.constants;


public enum XML {
    TOURISTSVOUCHERS("TouristVouchers"),
    HOTEL("hotel"),
    COST("Cost"),
    CURRENCY("Currency"),
    MEAL("Meal"),
    ROOM("Room"),
    TRANSPORT("Transport"),
    STARS("Stars"),
    DAYS("Days");

    private String value;

    XML(String value){
        this.value = value;
    }

    public boolean equalsTo(String name) {
        return value.equals(name);
    }

    public String value() {
        return value;
    }

}
