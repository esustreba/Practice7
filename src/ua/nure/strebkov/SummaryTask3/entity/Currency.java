package ua.nure.strebkov.SummaryTask3.entity;

public enum Currency {
    EUR("EUR"), USD("USD"), UAH("UAH"), RUB("RUB");

    private String value;

    Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
