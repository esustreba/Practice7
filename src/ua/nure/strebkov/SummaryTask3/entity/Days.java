package ua.nure.strebkov.SummaryTask3.entity;

public class Days {

    private Integer days;

    @Override
    public String toString() {
        return days.toString();
    }

    public Days(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

}
