package ua.nure.strebkov.SummaryTask3.entity;

public class Hotel {

    private String stars;
    private String days;
    private String transport;
    private String room;
    private String meal;
    private Cost cost;

    public Hotel () {

    }

    public Hotel(String stars, String days,
                   String transport, String room, String meal, Cost cost) {

        this.stars = stars;
        this.days = days;
        this.transport = transport;
        this.room = room;
        this.meal = meal;
        this.cost = cost;
    }



    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
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
        return "Hotel{" +
                ", stars='" + stars + '\'' +
                ", days='" + days + '\'' +
                ", transport='" + transport + '\'' +
                ", room='" + room + '\'' +
                ", meal='" + meal + '\'' +
                ", cost=" + cost +
                '}';
    }

}
