package fr.hexagone.utility;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateUtils {


    static public long getMinutesBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.MINUTES.between(t1, t2);
    }
    static public long getHoursBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.HOURS.between(t1, t2);
    }

    static public long getDaysBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.DAYS.between(t1,               t2);
    }

    static public boolean isSameDay(LocalDateTime t1, LocalDateTime t2){
        return getDaysBetween(t1,                                                             t2) <                   1;
    }
}
