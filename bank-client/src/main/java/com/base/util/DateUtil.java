package com.base.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * DateUtil.
 *
 * @author alex on 07/03/2022
 * @version 1.0
 * @since 1.0.0
 */
public final class DateUtil {

    /**
     * Constructor.
     */
    private DateUtil() {
    }

    /**
     * Obtiene la fecha actual LocalDateTime.
     *
     * @return Date
     * @author alex on 07/03/2022
     */
    public static Date currentDate() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Get date format.
     *
     * @param date date
     * @return Date
     */
    public static Date getDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startD = LocalDate.parse(date, formatter);
        return Date.from(startD.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


}
