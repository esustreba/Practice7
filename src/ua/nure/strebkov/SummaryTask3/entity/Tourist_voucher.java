package ua.nure.strebkov.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

public class Tourist_voucher {
    private List<Voucher> voucherList;

    public List<Voucher> getVoucher() {
        if(voucherList == null){
            voucherList = new ArrayList<Voucher>();
        }
        return voucherList;
    }

    @Override
    public String toString() {
        if(voucherList == null || voucherList.size() == 0){
            return "No trip";
        }
        StringBuilder result = new StringBuilder();
        for(Voucher v : voucherList){
            result.append(v).append('\n');
        }
        return result.toString();
    }
}
