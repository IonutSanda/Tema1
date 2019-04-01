package buildings;

/**
 * Created by Ionut on 3/31/2019.
 */
public class Hotel extends Address{
    private String hotelName;
    private double hotelRating;
    private int hotelCapacity;

    public Hotel(String hotelName, double hotelRating, int hotelCapacity){
        this.hotelName = hotelName;
        this.hotelRating = hotelRating;
        this.hotelCapacity = hotelCapacity;


    }

    public String getHotelName() {
        return hotelName;
    }

    public double getHotelRating() {
        return hotelRating;
    }

    public int getHotelCapacity() {
        return hotelCapacity;
    }

    @Override
    public String toString() {
        return "Name: " + hotelName + ", Rating: " + hotelRating + ", Capacity: " + hotelCapacity;
    }

}
