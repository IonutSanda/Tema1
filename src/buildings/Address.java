package buildings;

/**
 * Created by Ionut on 3/31/2019.
 */
public class Address extends Hotel {
    private final String streetName;
    private final int hotelNumber;
    private final String hotelCity;

    public Address(String streetName, int hotelNumber, String hotelCity, String hotelName, float hotelRating, int hotelCapacity) {
        super(hotelName, hotelRating, hotelCapacity);
        this.streetName = streetName;
        this.hotelNumber = hotelNumber;
        this.hotelCity = hotelCity;

    }

    @Override
    public String toString() {
        return "Address: " + streetName + ", " + hotelNumber + ", " + hotelCity + ", Hotel name: " + getHotelName() + ", Hotel Rating: " + getHotelRating() + ", Hotel Capacity: " + getHotelCapacity();
    }
}
