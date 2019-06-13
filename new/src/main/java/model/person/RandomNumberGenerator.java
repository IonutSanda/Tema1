package model.person;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class RandomNumberGenerator {

    public static String employeeNumberGenerator() {
        return RandomStringUtils.randomNumeric(2);
    }

    public static UUID hotelNumberGenerator() {
        return UUID.randomUUID();
    }

    public static String checkedInNumberGenerator(){
        return RandomStringUtils.randomNumeric(5);
    }

    public static Integer randomSleepTime () {
        return Integer.valueOf(RandomStringUtils.randomNumeric(2));
    }

    public static int randomHotelAssignment (int max, int min) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

}
