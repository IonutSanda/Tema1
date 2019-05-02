package HotelTests;

import model.ValidationException;
import model.building.*;
import model.enumaration.HasCapacity;
import repository.HotelRepository;
import service.HotelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HotelServiceTests {

    @Mock
    private HotelRepository hotelRepository;
    private HotelService hotelService;

    @Before
    public void setup(){
        hotelService = new HotelService(hotelRepository);
    }

    @Test
    public void shouldNot_Do_Anything_If_Added(){
        //GIVEN
        Hotel hotel = new Hotel("Ibis",250,4.7,"Street",26,"Cluj", HasCapacity.HAS_CAPACITY);
        doNothing().when(hotelRepository).add(hotel);
        verify(hotelRepository, times(0)).add(hotel);

    }

    @Test
    public void should_Add_After_Validation() throws ValidationException {
        //GIVEN
        Hotel hotel = new Hotel("Ibis",250,4.7,"Street",26,"Cluj", HasCapacity.HAS_CAPACITY);
//        doReturn("added").when(hotelRepository).add(any(Hotel.class));
        doNothing().when(hotelRepository).add(hotel);
        //WHEN
        String response = hotelService.validateAndAdd(hotel);
        //THEN
        assertEquals("Hotel has been added",response);

    }

    @Test(expected = NullPointerException.class)
    public void shouldNot_Add_If_Name_IsNull() throws ValidationException {
        //WHEN
        String response = hotelService.validateAndAdd(null);
        //THEN
        assertEquals("Please enter a Hotel name", response);
    }

    @Test
    public void shouldNot_Add_If_Name_IsEmpty() throws ValidationException {
        //GIVEN
        Hotel hotel = new Hotel("",250,4.7,"Street",26,"Cluj", HasCapacity.HAS_CAPACITY);
        //WHEN
        String response = hotelService.validateAndAdd(hotel);
        //THEN
        assertEquals("Please enter a Hotel name", response);
    }

    @Test
    public void shouldNot_Add_If_Capacity_TooLow() throws ValidationException {
        //GIVEN
        Hotel hotel = new Hotel("Ibis",20,4.7,"Street",26,"Cluj", HasCapacity.HAS_CAPACITY);
        //WHEN
        String response = hotelService.validateAndAdd(hotel);
        //THEN
        assertEquals("Hotel capacity under 100", response);

    }

    @Test
    public void shouldNot_Add_If_Rating_TooLow() throws ValidationException {
        //GIVEN
        Hotel hotel = new Hotel("Ibis",250,1.7,"Street",26,"Cluj", HasCapacity.HAS_CAPACITY);
        //WHEN
        String response = hotelService.validateAndAdd(hotel);
        //THEN
        assertEquals("Rating is too low",response);
    }

    @Test
    public void should_removeHotel() throws ValidationException {
        //GIVEN
        Hotel hotel = new Hotel("Ibis",300,4.6,"Street",25,"Cluj", HasCapacity.NO_CAPACITY);
        doReturn("removed").when(hotelRepository).remove(any(Hotel.class));
//        doNothing().when(hotelRepository).remove(hotel);
        //WHEN
        String response = hotelService.delete(hotel);
        //THEN
        assertEquals("removed",response);
    }

    @Test
    public void list_ShouldNot_BeEmpty_If_ValidData(){
        //GIVEN
        Hotel hotel = new Hotel("Ibis",300,4.6,"Street",25,"Cluj", HasCapacity.NO_CAPACITY);
        List<Hotel> hotels = new ArrayList<>();
        //WHEN
        hotels.add(hotel);
        //GIVEN
        assertFalse(hotels.isEmpty());
    }

    @Test
    public void list_Should_BeEmpty_If_HotelRemoved(){
        //GIVEN
        Hotel hotel = new Hotel("Ibis",30,4.6,"Street",25,"Cluj", HasCapacity.NO_CAPACITY);
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);
        //WHEN
        hotels.remove(hotel);
        //GIVEN
        assertTrue(hotels.isEmpty());
    }

}
