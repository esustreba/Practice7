package ua.nure.strebkov.SummaryTask3.entity;

public enum Type {
    WEEKEND("WEEKEND"), TOUR("TOUR"), RELAXATION("RELAXATION"), PILGRIMAGE("PILGRIMAGE");

    private String value;

    public String getValue() {
        return value;
    }

    Type(String value) {
        this.value = value;
    }
}
