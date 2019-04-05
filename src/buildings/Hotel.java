package buildings;

public class Hotel{
    private String hotelName;
    private float hotelRating;
    private int hotelCapacity;

    public Hotel(String hotelName, float hotelRating, int hotelCapacity){

        this.hotelName = hotelName;
        this.hotelRating = hotelRating;
        this.hotelCapacity = hotelCapacity;
    }
    public String getHotelName() {
        return hotelName;
    }
    public float getHotelRating() {
        return hotelRating;
    }
    public int getHotelCapacity() {
        return hotelCapacity;
    }
}
