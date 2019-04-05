package hotelandpersonlist;

import buildings.Hotel;
import java.util.ArrayList;
import java.util.List;

public class HotelsList {

    protected List<Hotel> hotels = new ArrayList<Hotel>();

    public void addHotel(Hotel hotel){
        hotels.add(hotel);
    }
    public void removeHotel(Hotel hotel){
        hotels.remove(hotel);
    }

    public List<Hotel> getHotels(){
        return hotels;
    }

}
