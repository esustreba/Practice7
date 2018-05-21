package ua.nure.strebkov.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

public class Tourist_vouchers {

    private List<Hotel> hotels;

    public List<Hotel> getHotels() {
        if (hotels == null) {
            hotels = new ArrayList<>();
        }
        return hotels;
    }

    @Override
    public String toString() {
        if (hotels == null || hotels.size() == 0) {
            return "Test contains no questions";
        }
        StringBuilder result = new StringBuilder();
        for (Hotel question : hotels) {
            result.append(question).append('\n');
        }
        return result.toString();
    }
}
