package com.spring.boot.kickstart.bicycleproject.util;

import java.util.Calendar;

public class DataUtil {

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

}
