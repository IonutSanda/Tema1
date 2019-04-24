import models.buildings.HasCapacity;
import models.buildings.Hotel;
import models.buildings.HotelRepository;
import models.buildings.HotelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTests {

    @Mock
    private HotelRepository hotelRepository;
    private HotelService hotelService;

    @Before
    public void setup(){
        hotelService = new HotelService(hotelRepository);
    }

    @Test
    public void should_Add_After_Validation(){
        //GIVEN
        Hotel hotel = new Hotel("Ibis",250,4.7,"Street",26,"Cluj", HasCapacity.HAS_CAPACITY);
        doReturn("added").when(hotelRepository).add(any(Hotel.class));
        //WHEN
        String response = hotelService.validateAndAdd(hotel);
        //THEN
        assertEquals("Hotel has been added",response);
    }

    @Test
    public void should_removeHotel(){
        //GIVEN
        Hotel hotel = new Hotel("Ibis",300,4.6,"Street",25,"Cluj", HasCapacity.NO_CAPACITY);
        doReturn("removed").when(hotelRepository).remove(any(Hotel.class));
        //WHEN
        String response = hotelService.delete(hotel);
        //THEN
        assertEquals("removed",response);


    }


}
