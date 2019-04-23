package models.buildings;

import java.util.List;

public interface HotelInterface {

    String add(Hotel hotel);

    String remove(Hotel hotel);

    List<Hotel> listHotels();

}
