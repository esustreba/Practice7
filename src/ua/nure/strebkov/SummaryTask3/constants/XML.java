package ua.nure.strebkov.SummaryTask3.constants;


public enum XML {
    TOURISTSVOUCHERS("TouristVouchers"),
    TOURISTSVOUCHER("TouristVousher"),
    COST("Cost"),
    CURRENCY("Currency"),
    MEALS("Meals"),
    ROOM("Room"),
    TRANSPORT("Transport"),
    TYPE("Type");

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
