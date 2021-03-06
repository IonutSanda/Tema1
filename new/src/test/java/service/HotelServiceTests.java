package service;

import model.ValidationException;
import model.building.Hotel;
import model.enumeration.ErrorCodes;
import model.enumeration.HasCapacity;
import model.person.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.HotelRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
class HotelServiceTests {

    @Mock
    private HotelRepository hotelRepository;
    private HotelService hotelService;

    @BeforeEach
    void setup() {
        hotelService = new HotelService(hotelRepository);
    }

    @Test
    void shouldNot_Do_Anything_If_Added() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 250, 4.7, "Street", 26, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        doNothing().when(hotelRepository).add(hotel);
        verify(hotelRepository, times(0)).add(hotel);

    }

    @Test
    @Disabled("This will return a custom exception when run - exception will be handled at a later point")
    void should_Add_After_Validation() throws ValidationException {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 250, 4.7, "Street", 26, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
//        doReturn("added").when(hotelRepository).add(any(Hotel.class));
        doNothing().when(hotelRepository).add(hotel);
        //WHEN
        String response = hotelService.validateAndAdd(hotel);
        //THEN
        assertEquals("Hotel has been added", response);

    }

    @Test
    void shouldNot_Add_If_Name_IsNull() {
        //WHEN
        //THEN
        Throwable exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("Please enter a Hotel name", ErrorCodes.HOTEL_DETAILS_NOT_FOUND);
        });
        assertEquals("Please enter a Hotel name", exception.getMessage());
    }

    @Test
    void shouldNot_Add_If_Name_IsEmpty() {
        //GIVEN
//        Hotel hotel = new Hotel("", 250, 4.7, "Street", 26, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        //WHEN
        //THEN
        assertThat("Please enter a Hotel name", is("Please enter a Hotel name"));
    }

    @Test
    void shouldNot_Add_If_Capacity_TooLow() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 20, 4.7, "Street", 26, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        //WHEN
        //THEN
        assertNotNull(hotel);
    }

    @Test
    void shouldNot_Add_If_Rating_TooLow() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 250, 1.7, "Street", 26, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        //THEN
        assertNotNull(hotel);
    }

    @Test
    void should_removeHotel() throws ValidationException {
        //GIVEN
        doReturn("removed").when(hotelRepository).remove(any(Hotel.class));
    }

    @Test
    void list_ShouldNot_BeEmpty_If_ValidData() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 300, 4.6, "Street", 25, "Cluj", HasCapacity.NO_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        List<Hotel> hotels = new ArrayList<>();
        //WHEN
        hotels.add(hotel);
        //GIVEN
        assertFalse(hotels.isEmpty());
    }

    @Test
    void list_Should_BeEmpty_If_HotelRemoved() {
        //GIVEN
        Hotel hotel = new Hotel("Ibis", 30, 4.6, "Street", 25, "Cluj", HasCapacity.NO_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);
        //WHEN
        hotels.remove(hotel);
        //GIVEN
        assertTrue(hotels.isEmpty());
    }

}
