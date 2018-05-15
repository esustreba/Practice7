package ua.nure.strebkov.SummaryTask3.entity;

public enum Transport {
    RAIL("RAIL"), PLAIN("PLAIN"), AUTO("AUTO"), SHIP("SHIP");

    private String value;

    Transport(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
