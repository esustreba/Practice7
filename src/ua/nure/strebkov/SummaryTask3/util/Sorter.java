package ua.nure.strebkov.SummaryTask3.util;

import ua.nure.strebkov.SummaryTask3.entity.Hotel;
import ua.nure.strebkov.SummaryTask3.entity.Tourist_vouchers;
import ua.nure.strebkov.SummaryTask3.constants.Constants;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {

    public static final Comparator<Hotel> SORT_HOTELS_BY_COST = new Comparator<Hotel>() {
        @Override
        public int compare(Hotel o1, Hotel o2) {
            return o1.getCosts().size() - o2.getCosts().size();
        }
    };

    public static final Comparator<Hotel> SORT_HOTELS_BY_NAME = new Comparator<Hotel>() {
        @Override
        public int compare(Hotel o1, Hotel o2) {
            return o1.toString().compareTo(o2.toString());
        }
    };

}