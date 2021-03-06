package fr.hexagone.utility;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    static final LocalDateTime t1 = LocalDateTime.of(2021, 12, 20, 13, 0, 0);
    static final LocalDateTime t2 = LocalDateTime.of(2021, 12, 20, 14, 0, 0);
    static final LocalDateTime t3 = LocalDateTime.of(2021, 12, 21, 13, 0, 0);
    static final LocalDateTime t4 = LocalDateTime.of(2021, 12, 27, 13, 0, 0);

    @Test
    void getMinutesBetween() {
        assertEquals(60, DateUtils.getMinutesBetween(t1, t2));
    }

    @Test
    void getHoursBetween() {
        assertEquals(1, DateUtils.getHoursBetween(t1, t2));
    }

    @Test
    void getDaysBetween() {
        assertEquals(1, DateUtils.getDaysBetween(t1, t3));
    }

    @Test
    void addMinutes() {
        LocalDateTime r = DateUtils.addMinutes(t1, 45);
        assertEquals(45, DateUtils.getMinutesBetween(t1, r));
    }

    @Test
    void isSameDay() {
        assertTrue(DateUtils.isSameDay(t1, t2));
        assertFalse(DateUtils.isSameDay(t1, t3));
    }

    @Test
    void isSameWeek() {
        assertTrue(DateUtils.isSameWeek(t1, t2));
        assertFalse(DateUtils.isSameWeek(t1, t4));
    }

    @Test
    void isOverlapping() {
        LocalDateTime start1 = LocalDateTime.of(2021, 12, 20, 13, 0, 0);
        LocalDateTime end1 = LocalDateTime.of(2021, 12, 20, 14, 0, 0);

        LocalDateTime start2 = LocalDateTime.of(2021, 12, 20, 13, 30, 0);
        LocalDateTime end2 = LocalDateTime.of(2021, 12, 20, 15, 0, 0);

        LocalDateTime start3 = LocalDateTime.of(2021, 12, 21, 13, 0, 0);
        LocalDateTime end3 = LocalDateTime.of(2021, 12, 21, 14, 0, 0);

        assertTrue(DateUtils.isOverlapping(start1, end1, start2, end2));
        assertFalse(DateUtils.isOverlapping(start1, end1, start3, end3));
    }
}