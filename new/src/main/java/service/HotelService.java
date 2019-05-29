package service;

import model.ValidationException;
import model.building.Hotel;
import model.enumeration.ErrorCodes;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import repository.HotelRepository;

import java.util.List;

public class HotelService {
    private static Logger logger = LogManager.getLogger(HotelRepository.class);

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @SuppressWarnings("deprecation")
    public String validateAndAdd(Hotel hotel) throws ValidationException {
        if (hotel.getRating() < 0) {
            throw new ValidationException("Rating must be positive", ErrorCodes.RATING_NEGATIVE);
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
            logger.debug("Hotel Name can not be NULL - class: HotelService; ln-37");
        }


        hotelRepository.add(hotel);
        return "Hotel has been added";
    }

    public List<Hotel> getHotels() {
        return hotelRepository.listHotels();
    }


}

