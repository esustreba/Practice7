package ua.nure.strebkov.SummaryTask3.entity;

public class Voucher {

    private String type;
    private String stars;
    private String country;
    private String days;
    private String transport;
    private String room;
    private String meal;
    private Cost cost;

    Voucher () {

    }

    public Voucher(String type, String stars, String country, String days,
                   String transport, String room, String meal, Cost cost) {
        this.type = type;
        this.stars = stars;
        this.country = country;
        this.days = days;
        this.transport = transport;
        this.room = room;
        this.meal = meal;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "type='" + type + '\'' +
                ", stars='" + stars + '\'' +
                ", country='" + country + '\'' +
                ", days='" + days + '\'' +
                ", transport='" + transport + '\'' +
                ", room='" + room + '\'' +
                ", meal='" + meal + '\'' +
                ", cost=" + cost +
                '}';
    }

}
