package models.buildings;

public class Address {

    private String streetName;
    private int number;
    private static String city;

    Address(String streetName, int number, String city) {
        this.streetName = streetName;
        this.number = number;
        Address.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        Address.city = city;
    }
}
