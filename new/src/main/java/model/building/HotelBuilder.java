package model.building;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.enumeration.HasCapacity;

import java.util.UUID;

@Getter
@Setter
@ToString
public class HotelBuilder {

    private UUID id = null;
    private String name = "";
    private int capacity = 0;
    private double rating= 0.0;
    private HasCapacity hasCapacity = null;

    private HotelBuilder(String name, int capacity, double rating, HasCapacity hasCapacity, UUID id) {
        this.name = name;
        this.capacity = capacity;
        this.rating = rating;
        this.hasCapacity = hasCapacity;
        this.id = id;
    }

    public HotelBuilder(String name){
        this.name = name;
    }


    public HotelBuilder setBuilderName(String name) {
        this.name = name;
        return this;
    }

    public HotelBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public HotelBuilder setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public HotelBuilder setHasCapacity(HasCapacity hasCapacity) {
        this.hasCapacity = hasCapacity;
        return this;
    }

    public HotelBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public HotelBuilder build() {
        return new HotelBuilder(name, capacity, rating, hasCapacity, id);
    }
}
