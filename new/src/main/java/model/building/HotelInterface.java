package model.building;

import model.ValidationException;

import java.util.List;

public interface HotelInterface {

    void add(Hotel hotel);

    String remove(Hotel hotel) throws ValidationException;

    List<Hotel> listHotels();

}
