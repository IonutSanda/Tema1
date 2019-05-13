package service;

import model.ValidationException;
import model.building.Hotel;
import repository.HotelRepository;

import java.util.List;

public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @SuppressWarnings("deprecation")
    public String validateAndAdd(Hotel hotel) throws ValidationException {
        if (hotel.getRating() < 0) {
            throw new ValidationException("Rating must be positive");
        }
        if (hotel.getHotelName().equals("")) {
            return "Please enter a Hotel name";
        }
        if (hotel.getName().length() < 1) {
            return "Please enter a Hotel name";
        }
        if (hotel.getCapacity() < 100) {
            return "Hotel capacity under 100";
        }
        if (hotel.getRating() < 2.5) {
            return "Rating is too low";
        }

        try {
            validateAndAdd(null);
        } catch (NullPointerException e) {
            System.out.println("Hotel Name can not be NULL - class: HotelService; ln-37");
        }


        hotelRepository.add(hotel);
        return "Hotel has been added";
    }

    public String delete(Hotel hotel) throws ValidationException {
        hotelRepository.remove(hotel);
        return "removed";
    }

    public List<Hotel> getHotels() {
        return hotelRepository.listHotels();
    }


}

