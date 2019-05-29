package model.building;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.enumeration.HasCapacity;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class HotelBuilderLombok {

    private String name = "";
    private int capacity = 0;
    private double rating = 0.0;
    private HasCapacity hasCapacity = null;
    private UUID id = null;
}
