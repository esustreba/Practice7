package ua.nure.strebkov.SummaryTask3.entity;

public class Country {
    private String country;

    @Override
    public String toString() {
        return country.toString();
    }

    public Country(String country) {
        this.country = country;

}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
