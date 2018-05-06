package ua.nure.strebkov.SummaryTask3;

import org.jdom.Attribute;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import ua.nure.strebkov.SummaryTask3.voucher.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DOMHandler {
    public static void main(String[] args) {

        String fileName = "input.xml";
        if (!XMLValidator.isValidXml(fileName)) {
            System.out.println("File is not valid, please, provide valid xml file");
            return;
        }
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(fileName);
            Element root = document.getRootElement();
            List<TouristVousher> vouchers = getTouristVouchers(root);
            for (TouristVousher touristVoucher : vouchers){
                System.out.println(touristVoucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static List<TouristVousher> getTouristVouchers(Element root) {
        List<TouristVousher> vouchers = new ArrayList<>();
        for (Element element : (List<Element>) root.getChildren()){
            TouristVousher currentVoucher = new TouristVousher();
            currentVoucher.setId(getSoleAttrValue(element));
            setType(element, currentVoucher);
            setCountry(element, currentVoucher);
            setNumberDaysNights(element, currentVoucher);
            setTransport(element, currentVoucher);
            setHotelProps(element, currentVoucher);
            setCost(element, currentVoucher);
            vouchers.add(currentVoucher);
        }
        return vouchers;
    }

    private static void setHotelProps(Element element, TouristVousher currentVoucher) {
        HotelProps currentHotelProps = new HotelProps();
        Element hotelElement = element.getChild("hotelProps");
        String stars = getSoleContentValueByTagName(hotelElement, "stars");
        currentHotelProps.setStars(Integer.valueOf(stars));
        String meals = getSoleContentValueByTagName(hotelElement, "meals");
        currentHotelProps.setMeals(Meals.valueOf(meals.toUpperCase()));
        String roomPlaces = getSoleContentValueByTagName(hotelElement, "roomPlaces");
        currentHotelProps.setRoomPlaces(Integer.valueOf(roomPlaces));
        String condition = getSoleContentValueByTagName(hotelElement, "condition");
        currentHotelProps.setCondition(condition);
        String TV = getSoleContentValueByTagName(hotelElement, "TV");
        currentHotelProps.setTV(TV);
        String WIFI = getSoleContentValueByTagName(hotelElement, "WIFI");
        currentHotelProps.setWIFI(WIFI);
        String freeParking = getSoleContentValueByTagName(hotelElement, "freeParking");
        currentHotelProps.setFreeParking(freeParking);
        currentVoucher.setHotelProps(currentHotelProps);
    }

    private static void setCost(Element element, TouristVousher currentVoucher) {
        Cost currentPrice = new Cost();
        currentPrice.setCurrency(Currency.valueOf(getSoleAttrValue(element.getChild("cost"))));
        String cost = getSoleContentValueByTagName(element, "cost");
        currentPrice.setValue(new BigDecimal(cost));
        currentVoucher.setCost(currentPrice);
    }

    private static void setTransport(Element element, TouristVousher currentVoucher) {
        String transport = getSoleContentValueByTagName(element, "transport");
        currentVoucher.setTransport(Transport.valueOf(transport.toUpperCase()));
    }

    private static void setNumberDaysNights(Element element, TouristVousher currentVoucher) {
        String numberDaysNights = getSoleContentValueByTagName(element, "numberDaysNights");
        currentVoucher.setDays(new BigInteger(numberDaysNights));
    }

    private static void setCountry(Element element, TouristVousher currentVoucher) {
        String country = getSoleContentValueByTagName(element, "country");
        currentVoucher.setCountry(country);
    }

    private static void setType(Element element, TouristVousher currentVoucher) {
        String type = getSoleContentValueByTagName(element, "type");
        currentVoucher.setType(Type.valueOf(type.toUpperCase()));
    }

    private static String getSoleContentValueByTagName(Element element, String tagName) {
        return  element.getChild(tagName).getContent(0).getValue();
    }

    private static String getSoleAttrValue(Element element) {
        return ((Attribute) element.getAttributes().get(0)).getValue();
    }
}
