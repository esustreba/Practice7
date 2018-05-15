package ua.nure.strebkov.SummaryTask3.entity;

public enum Room {
    STANDART("Standart"), SUITE("Suite"), LUX("Lux"), VILLA("Villa");


    private String value;

    Room(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
