package ua.nure.strebkov.SummaryTask3.entity;

public class Cost {

    private String currency;

    public Cost() {

    }

    public Cost(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "currency='" + currency + '\'' +
                '}';
    }
}
