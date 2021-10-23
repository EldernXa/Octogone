package fr.hexagone.utility;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DateUtils {


    static public long getMinutesBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.MINUTES.between(t1, t2);
    }
    static public long getHoursBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.HOURS.between(t1, t2);
    }

    static public long getDaysBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.DAYS.between(t1,t2);
    }


    static public LocalDateTime addMinutes(LocalDateTime t1, long minutes) {
        return t1.plusMinutes(minutes);
    }

    static public boolean isSameDay(LocalDateTime t1, LocalDateTime t2){
        return t1.getDayOfMonth() == t2.getDayOfMonth();
    }

    static public boolean isSameWeek(LocalDateTime t1, LocalDateTime t2){
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = t1.get(weekFields.weekOfWeekBasedYear());

        WeekFields week2 = WeekFields.of(Locale.getDefault());
        int weekNumber2 = t2.get(week2.weekOfWeekBasedYear());

        return weekNumber2 == weekNumber;
    }

    public static boolean isOverlapping(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return start1.isBefore(end2) && end1.isAfter(start2);
    }
}
