package models.buildings;

import java.util.List;

public class HotelService {

    private HotelRepository hotelRepository;
    public HotelService (HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    public String validateAndAdd(Hotel hotel) {
        if (hotel.getName().equals("")) {
            return "Please enter a Hotel name";
        }
        if (hotel.getCapacity() < 100) {
            return "Hotel capacity under 100";
        }
        if (hotel.getRating() < 2.5) {
            return "Rating is too low";
        }

        hotelRepository.add(hotel);
        return "Hotel has been added";
    }

    public String delete(Hotel hotel) {
        hotelRepository.remove(hotel);
        return "removed";
    }

    public List<Hotel> getHotels() {
        return hotelRepository.listHotels();
    }


}

