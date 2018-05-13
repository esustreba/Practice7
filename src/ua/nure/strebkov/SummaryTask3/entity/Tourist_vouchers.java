package ua.nure.strebkov.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

public class Tourist_vouchers {

    private List<Voucher> vouchers;

    public List<Voucher> getVoucher() {
        if (vouchers == null) {
            vouchers = new ArrayList<>();
        }
        return vouchers;
    }

    @Override
    public String toString() {
        if (vouchers == null || vouchers.size() == 0) {
            return "Test contains no questions";
        }
        StringBuilder result = new StringBuilder();
        for (Voucher question : vouchers) {
            result.append(question).append('\n');
        }
        return result.toString();
    }
}
