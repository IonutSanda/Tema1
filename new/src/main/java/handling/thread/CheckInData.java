package handling.thread;

import model.person.RandomNumberGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class CheckInData {

    private static LocalTime localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    private static LocalDate localDate = LocalDate.now();

    static String getDateAndTime() {
        return "Client has checked in at: " + localTime + " on " + localDate + " CheckIn ID: " + RandomNumberGenerator.checkedInNumberGenerator();
    }

    static LocalDate getDate() {
        return localDate;
    }

    static LocalTime getTime() {
        return localTime;
    }
}
