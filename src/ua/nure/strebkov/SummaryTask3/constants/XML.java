package ua.nure.strebkov.SummaryTask3.constants;


public enum XML {
    TOURISTSVOUCHERS("TouristVouchers"),
    VOUCHER("Voucher"),
    COST("Cost"),
    CURRENCY("Currency"),
    MEAL("Meal"),
    ROOM("Room"),
    TRANSPORT("Transport"),
    TYPE("Type"),
    STARS("Stars"),
    COUNTRY("Country"),
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
