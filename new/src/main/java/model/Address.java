package model;

public class Address {

    private String streetName;
    private int number;
    private static String city;

    protected Address(String streetName, int number, String city) {
        this.streetName = streetName;
        this.number = number;
        Address.city = city;
    }

    protected String getStreetName() {
        return streetName;
    }

    protected void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    protected int getNumber() {
        return number;
    }

    protected void setNumber(int number) {
        this.number = number;
    }

    protected String getCity() {
        return city;
    }

    protected void setCity(String city) {
        Address.city = city;
    }
}
