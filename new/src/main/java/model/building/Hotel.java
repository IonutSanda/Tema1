package model.building;

import lombok.Getter;
import lombok.Setter;
import model.Address;
import model.enumeration.HasCapacity;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class Hotel extends Address implements Serializable {

    private UUID id;
    private String name;
    private int capacity;
    private double rating;
    private HasCapacity hasCapacity;
    //for DB purpose only
    private int idList;
    private boolean availabilityList;
    private String nameList;
    private double ratingList;
    private int capacityList;

    public Hotel(String name, int capacity, double rating, String streetName, int number, String city, HasCapacity hasCapacity, UUID id) {
        super(streetName, number, city);
        this.name = name;
        this.capacity = capacity;
        this.rating = rating;
        this.hasCapacity = hasCapacity;
        this.id = id;
    }

    public Hotel() {
    }

    public String isAvailable() {
        return hasCapacity.getMessage();
    }

    @Deprecated
    public String getHotelName() {
        return "Hotel Name: " + name;
    }

    @Override
    public String toString() {
        return "Hotel ID: " + idList + ", Name: " + nameList+ ", Capacity: " + capacityList;
    }

    public String toStringList() {
        return "ID: " + id + ", Name: " + name + ", Capacity: " + capacity + ", Rating: " + rating + ", Available: " + isAvailable();
    }

}
