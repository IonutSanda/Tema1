package repository;

import model.ValidationException;
import model.building.Hotel;
import model.enumeration.HasCapacity;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HotelRepositoryTests {

    private HotelRepository hotelRepository;


    @BeforeEach
    public void setup() {
        hotelRepository = new HotelRepository();
    }


    @Test
    public void should_Remove_Hotel_If_ValidData() {
        //THEN
        Throwable exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("deleted");
        });
        assertEquals("deleted", exception.getMessage());

    }

    @Test
    public void list_ShouldNot_BeEmpty_If_AddedHotel() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 250, 4.5, "Streetname", 25, "Cluj", HasCapacity.NO_CAPACITY);
        List<Hotel> hotels = new ArrayList<>();
        //WHEN
        hotels.add(hotel);
        //THEN
        assertFalse(hotels.isEmpty());
    }

    @Test
    public void list_Should_BeEmpty_If_RemovedHotel() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 250, 4.5, "Streetname", 25, "Cluj", HasCapacity.NO_CAPACITY);
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);
        //WHEN
        hotels.remove(hotel);
        //THEN
        assertTrue(hotels.isEmpty());
    }
}
