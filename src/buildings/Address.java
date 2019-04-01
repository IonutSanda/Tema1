package buildings;

/**
 * Created by Ionut on 3/31/2019.
 */
public class Address {

    private String buildingCity;
    private String streetName;
    private int buildingNumber;

    public String getBuildingCity() {
        return buildingCity;
    }

    private void setBuildingCity(String buildingCity) {
        this.buildingCity = buildingCity;
    }

    public String getStreetName() {
        return streetName;
    }

    private void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    private void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString(){
        return "Street: " + streetName + ", Nr: " + buildingNumber + ", City: " + buildingCity;
    }
}
