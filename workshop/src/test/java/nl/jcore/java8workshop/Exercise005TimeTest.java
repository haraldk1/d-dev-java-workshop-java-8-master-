package nl.jcore.java8workshop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Exercise005TimeTest {
    private static final String TIMEZONE_EUROPE_AMSTERDAM = "Europe/Amsterdam";
    private static final String TIMEZONE_EUROPE_LONDON = "Europe/London";
    private static final Instant FOURTH_OF_FEBRUARY = Instant.ofEpochMilli(1486162800000L);
    private static final Instant WORKSHOP_DAY = Instant.ofEpochMilli(1488927600000L);

    @Test
    public void test001GetLocalDate() {
        final Clock clockA = Clock.fixed(WORKSHOP_DAY, ZoneId.of(TIMEZONE_EUROPE_AMSTERDAM));
        assertEquals(LocalDate.of(2019, 3, 28), Exercise005Time.getLocalDateOfToday(clockA));

        final Clock clockB = Clock.fixed(FOURTH_OF_FEBRUARY, ZoneId.of(TIMEZONE_EUROPE_AMSTERDAM));
        assertEquals(LocalDate.of(2019, 3, 28), Exercise005Time.getLocalDateOfToday(clockB));
    }

    @Test
    public void test002GetZonedDateTimeFromDateTimeAndTimezone() {
        final LocalDateTime dateTime = LocalDate.of(2019, 3, 27).atStartOfDay();
        final ZoneId zoneId = ZoneId.of(TIMEZONE_EUROPE_AMSTERDAM);        
        final ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
        assertEquals(zonedDateTime, Exercise005Time.getZonedDateTimeFromDateTimeAndTimezone(dateTime, zoneId));

    }

    @Test
    public void test003GetInstantFromDate() {
        final LocalDateTime dateTime = LocalDate.of(2017, 2, 4).atStartOfDay();
        final ZoneId zoneId = ZoneId.of(TIMEZONE_EUROPE_AMSTERDAM);
        //final ZoneId zoneId = ZoneId.of(TIMEZONE_EUROPE_LONDON);
        //final ZoneId zoneId = ZoneId.systemDefault();  
       // final ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
        assertEquals(dateTime, Exercise005Time.getInstantFromDateTimeAndTimezone(dateTime, zoneId));
    }

    @Test
    public void test004AddDay() {
        final LocalDate date = LocalDate.of(2017, 3, 2);
        final LocalDate expectedDate = LocalDate.of(2017, 3, 3);
        assertEquals(expectedDate, Exercise005Time.addDay(date));
    }

    @Test
    public void test005GetDuration() {
        test005GetDuration(0);
        test005GetDuration(1);
        test005GetDuration(23);
        test005GetDuration(200);
    }

    private void test005GetDuration(final int minutes) {
        final Instant a = Instant.now();
        final Instant b = a.plus(minutes, ChronoUnit.MINUTES);
        assertEquals(Math.abs(Duration.ofMinutes(minutes).toMillis()), Math.abs(Exercise005Time.getDurationFromInstants(a, b).toMillis()));
    }
}
