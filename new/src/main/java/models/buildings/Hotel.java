package models.buildings;

public class Hotel extends Address {

    private String name;
    private int capacity;
    private double rating;
    private HasCapacity hasCapacity;

    public Hotel(String name, int capacity, double rating, String streetName, int number, String city, HasCapacity hasCapacity) {
        super(streetName, number, city);
        this.name = name;
        this.capacity = capacity;
        this.rating = rating;
        this.hasCapacity = hasCapacity;
    }

    public String isAvailable(){
        return hasCapacity.getMessage();
    }

    @Deprecated
    public String getName() {
        return name;
    }
    private String getHotelName() {
        return "Hotel Name: " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString(){
        return getHotelName() + ", Capacity: " + capacity + ", Rating: " + rating;
    }
}
