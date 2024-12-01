package cleancode.studycafe.tobe2.model;

import java.util.stream.Stream;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권", "1"),
    WEEKLY("주 단위 이용권", "2"),
    FIXED("1인 고정석", "3");

    public final String description;
    public final String number;

    StudyCafePassType(String description, String number) {
        this.description = description;
        this.number = number;
    }

}
