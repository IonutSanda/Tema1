package repository;

import model.ValidationException;
import model.building.Hotel;
import model.building.HotelInterface;
import model.enumeration.ErrorCodes;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;


public class HotelRepository implements HotelInterface<Hotel> {
    private static Logger logger = LogManager.getLogger(HotelRepository.class);

    private List<Hotel> hotels = new ArrayList<model.building.Hotel>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Hotel hotel) {
        hotels.add(hotel);
        logger.debug("Hotel has been added");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Hotel hotel) throws ValidationException {
        if (hotels.size() == 0) {
            logger.error("Name from the hotel is missing - HotelRepository Class - ln. 233" + ErrorCodes.HOTEL_NOT_FOUND);
            throw new ValidationException("There are no hotels to delete", ErrorCodes.HOTEL_NOT_FOUND);
        }
        hotels.remove(hotel);
        logger.debug("Hotel has been deleted");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Hotel> listHotels() {
        return hotels;
    }
}
