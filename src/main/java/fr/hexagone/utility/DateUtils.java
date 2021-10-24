package fr.hexagone.utility;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DateUtils {

    /**
     * Retourne le nombre de minutes entre deux dates
     * @param t1 premiere date
     * @param t2 seconde date
     * @return nombre de minutes
     */
    static public long getMinutesBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.MINUTES.between(t1, t2);
    }

    /**
     * Retourne le nombre d'heures entre deux dates
     * @param t1 premiere date
     * @param t2 seconde date
     * @return nombre d'heures
     */
    static public long getHoursBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.HOURS.between(t1, t2);
    }

    /**
     * Retourne le nombre de jours entre deux dates
     * @param t1 premiere date
     * @param t2 seconde date
     * @return nombre de jours
     */
    static public long getDaysBetween(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.DAYS.between(t1,t2);
    }


    /**
     * Ajoute un nombre de minutes à une date
     * @param t1 date
     * @param minutes minutes à ajouter
     * @return date résultante
     */
    static public LocalDateTime addMinutes(LocalDateTime t1, long minutes) {
        return t1.plusMinutes(minutes);
    }

    /**
     * Retourne vrai si deux dates sont du même jour calendaire
     * @param t1 premiere date
     * @param t2 seconde date
     * @return vrai/faux
     */
    static public boolean isSameDay(LocalDateTime t1, LocalDateTime t2){
        return t1.getDayOfMonth() == t2.getDayOfMonth();
    }

    /**
     * Retourne vrai si deux dates sont de la même semaine calendaire
     * @param t1 premiere date
     * @param t2 seconde date
     * @return vrai/faux
     */
    static public boolean isSameWeek(LocalDateTime t1, LocalDateTime t2){
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = t1.get(weekFields.weekOfWeekBasedYear());

        WeekFields week2 = WeekFields.of(Locale.getDefault());
        int weekNumber2 = t2.get(week2.weekOfWeekBasedYear());

        return weekNumber2 == weekNumber;
    }

    /**
     * Retourne vrai si deux plages temporelles se chevauchent
     * @param start1 début de la plage 1
     * @param end1 fin de la plage 1
     * @param start2 debut de la plage 2
     * @param end2 fin de la plage 2
     * @return vrai/faux
     */
    public static boolean isOverlapping(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return ( start1.isBefore(start2) && end1.isAfter(start2) ) || ( start2.isBefore(start1) && end2.isAfter(start1) );
    }
}
