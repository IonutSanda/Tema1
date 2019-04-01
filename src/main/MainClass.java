package main;

import buildings.Hotel;

/**
 * Created by Ionut on 3/31/2019.
 */
public class MainClass {

    public static void main(String... args) {
        Hotel firstHotel = new Hotel("Ibis", 4.7, 100);
        System.out.println(firstHotel.toString());
        Hotel secondHotel = new Hotel("Ramada", 4.5, 125);
        System.out.println(secondHotel.toString());

    }
}
