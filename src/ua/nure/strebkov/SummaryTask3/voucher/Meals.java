package ua.nure.strebkov.SummaryTask3.voucher;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for meals.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="meals">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HB"/>
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="Al"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */

@XmlType(name = "meals")
@XmlEnum
public enum Meals {
    HB("HB"),
    BB("BB"),
    @XmlEnumValue("Al")
    AL("Al");
    private final String value;

    Meals(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Meals fromValue(String v) {
        for (Meals c: Meals.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
