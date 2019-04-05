package buildings;

public class Room extends Hotel {

    private final int floor;

    public Room(String hotelName, int floor, float hotelRating, int hotelCapacity) {
        super(hotelName, hotelRating, hotelCapacity);
        this.floor = floor;
    }
}
