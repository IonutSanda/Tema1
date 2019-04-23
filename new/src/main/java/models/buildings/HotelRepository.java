package models.buildings;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository implements HotelInterface {

    private List<Hotel> hotels = new ArrayList<>();

    @Override
    public String add(Hotel hotel) {
        hotels.add(hotel);
        return "added";
    }

    @Override
    public String remove(Hotel hotel) {
        hotels.remove(hotel);
        return "deleted";
    }

    @Override
    public List<Hotel> listHotels() {
        return hotels;
    }
}
