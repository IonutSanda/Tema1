import models.buildings.HasCapacity;
import models.buildings.Hotel;
import models.buildings.HotelRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelRepositoryTests {

    private HotelRepository hotelRepository;

    @Before
    public void setup() {
        hotelRepository = new HotelRepository();
    }

    @Test
    public void should_Add_Hotel_If_ValidData(){

        //GIVEN
        Hotel hotel = new Hotel("Ibis",150,4.3,"Ibis Street",27,"Cluj", HasCapacity.HAS_CAPACITY);

        //WHEN
        String response = hotelRepository.add(hotel);

        //THEN
        assertEquals("added", response);

    }

    @Test
    public void should_Remove_Hotel_If_ValidData(){
        //GIVEN
        Hotel hotel = new Hotel("Ibis",250,4.5,"Streetname",25,"Cluj", HasCapacity.HAS_CAPACITY);
        //WHEN
        String response = hotelRepository.remove(hotel);
//        THEN
        assertEquals("deleted",response);
    }

}
