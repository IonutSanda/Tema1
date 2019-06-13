package handling.thread;

import model.person.RandomNumberGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CheckInData {

    private static LocalTime localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    private static LocalDate localDate = LocalDate.now();

    public static String getDateAndTime() {
        return "Client has checked in at: " + localTime + " on " + localDate + " CheckIn ID: " + RandomNumberGenerator.checkedInNumberGenerator();
    }

    public static LocalDate getDate() {
        return localDate;
    }

    public static LocalTime getTime() {
        return localTime;
    }
}
