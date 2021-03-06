package model.building;

import model.ValidationException;

import java.util.List;

/**
 * Here are the methods defined to add, remove and List the Hotels
 * which will be added through the MainClass
 */

public interface HotelInterface<T> {

    /**
     * Add the hotel to a created list
     *
     * @param hotel - Hotel which will be added
     */
    void add(T hotel);

    /**
     * Remove the hotel, which was added, from a created list
     *
     * @param hotel - Hotel which will be added
     * @throws ValidationException - this is a custom exception which will throw a custom message
     *                             if the hotel can not be removed; Reason why it can not be removed
     *                             is that there are no hotels to remove from the list
     */
    void remove(T hotel) throws ValidationException;

    /**
     * Display the hotels which were added to the created list
     *
     * @return returns the list of the hotels
     */
    List<T> listHotels();

}
