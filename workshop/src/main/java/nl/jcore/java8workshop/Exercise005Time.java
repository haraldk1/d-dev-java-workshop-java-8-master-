package nl.jcore.java8workshop;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Exercise005Time {
    /**
     * Return the LocalDate of today. Using the clock
     * object here makes time and timing testable. In
     * a test you can simply mock a clock with a fixed
     * time. The clock can freeze or tick whenever the
     * test requires it to.
     *
     * This is why LocalDate.of(2017, 3, 8); won't
     * work as a solution here ;)
     */
    static LocalDate getLocalDateOfToday(final Clock clock) {
        
        Clock c = Clock.systemUTC();
//        System.out.println(c.instant());
        
//        LocalDate date = LocalDate.now();        
//        return date;
        
        return LocalDate.now();
    }

    /**
     * Combine LocalDateTime and ZoneId (timezone)
     * information into a ZonedDateTime.
     *
     * A great thing about the java.time.* classes are
     * their descriptive names. The intent of the method
     * below should be clear from just its parameters
     * and return type. The classes' names indicate what
     * information they hold and therefore what purpose
     * they serve.
     */
    static ZonedDateTime getZonedDateTimeFromDateTimeAndTimezone(final LocalDateTime dateTime, final ZoneId zoneId) {
        
        //System.out.println(dateTime+ "   " + zoneId);
        ZonedDateTime z = ZonedDateTime.of(dateTime, zoneId);        
        return z;
    }

    /**
     * Derive the Instant (single point in linear time) from a LocalDateTime and a ZoneId.
     */
    static Instant getInstantFromDateTimeAndTimezone(final LocalDateTime dateTime, final ZoneId zoneId) {
        
//        System.out.println(dateTime);
//        System.out.println(zoneId);
        ZonedDateTime z = ZonedDateTime.of(dateTime, zoneId); 
        System.out.println("z before  " + z);
        z = z.plusHours(1);
        System.out.println("z after   " + z);
        Instant res = z.toInstant();
        System.out.println("res =   " + res);
        
        
        //Create formatter
DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm");
 
//Get formatted String
z = z.minusHours(1);
String zdtString = z.format(FOMATTER);
System.out.println("formatiert :  " +zdtString); 
LocalDateTime localdateTime = LocalDateTime.parse(zdtString);
Instant e = localdateTime.toInstant(ZoneOffset.UTC);
System.out.println("e =  " + e);

/*CharSequence cs = zdtString;
Instant fres = Instant.parse(cs);
System.out.println("fres =   " + fres);*/
        
        // versuchen anzupassen  --> Unsupported field: DayOfMonth
        /*        Instant a = z.toInstant();
        System.out.println("a = " + a.with(ChronoField.DAY_OF_MONTH, 5));
        System.out.println("a after with  " + a);*/
        
        

        
        /*Temporal rt = i.adjustInto(z);
        System.out.println("rt = " + (ZonedDateTime)rt);*/

        
//        i = i.truncatedTo(ChronoUnit.MINUTES);
//        System.out.println("i " + i);
        
//        Instant j = Instant.parse(z.toString());
//        System.out.println("j " + j);


        //return a;
        return res;
    }

    /**
     * Return a LocalDate that is one day later than the input LocalDate.
     */
    static LocalDate addDay(final LocalDate date) {
        final TemporalUnit unit = ChronoUnit.DAYS;
        LocalDate res = date;
        res = res.plusDays(1);
        return res;
        
    }

    /**
     * Return the Duration between two instants.
     */
    static Duration getDurationFromInstants(final Instant instantA, final Instant instantB) {
        Duration d = Duration.between(instantA, instantB);
        return d;
    }
}
