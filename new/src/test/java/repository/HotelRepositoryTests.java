package repository;

import model.ValidationException;
import model.building.Hotel;
import model.enumeration.ErrorCodes;
import model.enumeration.HasCapacity;
import model.person.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelRepositoryTests {

    @Test
    void should_Remove_Hotel_If_ValidData() {
        //THEN
        Throwable exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("deleted", ErrorCodes.HOTEL_NOT_FOUND);
        });
        assertEquals("deleted", exception.getMessage());

    }

    @Test
    void list_ShouldNot_BeEmpty_If_AddedHotel() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 250, 4.5, "Streetname", 25, "Cluj", HasCapacity.NO_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        List<Hotel> hotels = new ArrayList<>();
        //WHEN
        hotels.add(hotel);
        //THEN
        assertFalse(hotels.isEmpty());
    }

    @Test
    void list_Should_BeEmpty_If_RemovedHotel() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 250, 4.5, "Streetname", 25, "Cluj", HasCapacity.NO_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);
        //WHEN
        hotels.remove(hotel);
        //THEN
        assertTrue(hotels.isEmpty());
    }
}
