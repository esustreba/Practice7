package ua.nure.strebkov.SummaryTask3.util;

import ua.nure.strebkov.SummaryTask3.entity.Cost;
import ua.nure.strebkov.SummaryTask3.entity.Hotel;
import ua.nure.strebkov.SummaryTask3.entity.Tourist_vouchers;
import ua.nure.strebkov.SummaryTask3.constants.Constants;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {

    public static final Comparator<Hotel> SORT_HOTEL_BY_NAME =
            (o1, o2) -> o1.toString().compareTo(o2.toString());



    public static final void setSortHotelByName(Tourist_vouchers hotel) {
        Collections.sort(hotel.getHotels(), SORT_HOTEL_BY_NAME);
    }

}
