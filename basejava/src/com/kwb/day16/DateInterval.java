package com.kwb.day16;

import java.time.LocalDate;

public class DateInterval extends Pair<LocalDate> {

    public void setSecond(LocalDate date) {
        super.setSecond(date);
    }

    public DateInterval(LocalDate first, LocalDate second) {
        super(first, second);
    }
}
