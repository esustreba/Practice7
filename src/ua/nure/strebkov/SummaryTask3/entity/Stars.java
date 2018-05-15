package ua.nure.strebkov.SummaryTask3.entity;

public class Stars {
    private Integer stars;

    public Integer getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return stars.toString();
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Stars(Integer stars) {

        this.stars = stars;
    }
}
