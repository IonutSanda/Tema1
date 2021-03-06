package handling.thread;

import model.person.RandomNumberGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CheckInData {

    private LocalTime localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    private LocalDate localDate = LocalDate.now();

    public String getDateAndTime() {
        return "Client has checked in at: " + localTime + " on " + localDate + " CheckIn ID: " + RandomNumberGenerator.checkedInNumberGenerator();
    }

    public LocalDate getDate() {
        return localDate;
    }

    public LocalTime getTime() {
        return localTime;
    }
}
