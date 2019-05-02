package HotelTests;

import model.ValidationException;
import model.enumaration.HasCapacity;
import model.building.Hotel;
import repository.HotelRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HotelRepositoryTests {

    private HotelRepository hotelRepository;


    @Before
    public void setup() {
        hotelRepository = new HotelRepository();
    }


    @Test(expected = ValidationException.class)
    public void should_Remove_Hotel_If_ValidData() throws ValidationException {
        //GIVEN
        Hotel hotel = new Hotel("Ibis",250,4.5,"Streetname",25,"Cluj", HasCapacity.NO_CAPACITY);
        //WHEN
        String response = hotelRepository.remove(hotel);
//        THEN
        assertEquals("deleted",response);
    }

    @Test
    public void list_ShouldNot_BeEmpty_If_AddedHotel(){
        //GIVEN
        Hotel hotel = new Hotel("Ibis",250,4.5,"Streetname",25,"Cluj", HasCapacity.NO_CAPACITY);
        List<Hotel> hotels = new ArrayList<>();
        //WHEN
        hotels.add(hotel);
        //THEN
        assertFalse(hotels.isEmpty());
    }

    @Test
    public void list_Should_BeEmpty_If_RemovedHotel(){
        //GIVEN
        Hotel hotel = new Hotel("Ibis",250,4.5,"Streetname",25,"Cluj", HasCapacity.NO_CAPACITY);
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);
        //WHEN
        hotels.remove(hotel);
        //THEN
        assertTrue(hotels.isEmpty());
    }
}
