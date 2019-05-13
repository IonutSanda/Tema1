package repository;

import model.ValidationException;
import model.building.Hotel;
import model.building.HotelInterface;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class HotelRepository implements HotelInterface {
    private static Logger logger = Logger.getLogger(HotelRepository.class);

    private List<Hotel> hotels = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Hotel hotel) {
        hotels.add(hotel);
        logger.debug("Hotel has been added");
//        return "added";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String remove(Hotel hotel) throws ValidationException {
        if (hotels.size() == 0) {
            logger.error("Name from the hotel is missing - HotelRepository Class - ln. 233");
            throw new ValidationException("There are no hotels to delete");
        }
        hotels.remove(hotel);
        logger.debug("Hotel has been deleted");
        return "deleted";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Hotel> listHotels() {
        return hotels;
    }
}
