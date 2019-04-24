package models;

import models.buildings.HasCapacity;
import models.buildings.Hotel;
import models.buildings.HotelRepository;
import models.buildings.HotelService;
import models.persons.Gender;
import models.persons.Person;
import models.persons.PersonRepository;
import models.persons.PersonService;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {

        Hotel firstHotel = new Hotel("Ibis", 150, 4.3, "Ibis Street", 25, "Cluj", HasCapacity.NO_CAPACITY);
        Hotel secondHotel = new Hotel("Hilton", 250, 5, "Hilton Street", 88, "Cluj", HasCapacity.HAS_CAPACITY);
        Hotel thirdHotel = new Hotel("Ramada and CO", 300, 4.7, "Ramada Street", 12, "Cluj", HasCapacity.HAS_CAPACITY);

        Person firstClient = new Person("Ionut Sanda", 28, "sanda@me.com", Gender.MALE);
        Person firstEmployee = new Person("Sanda Ionut", "ionut@me.com", 27, "123ABC", Gender.MALE);

        Person secondClient = new Person("Iulia Ferencz", 27, "iulia@me.com", Gender.FEMALE);
        Person secondEmployee = new Person("Ferencz Iulia", "ferencz@me.com", 26, "4321CBA", Gender.FEMALE);

        //mocking reasons for creating a new repo
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);
        PersonRepository personRepository = new PersonRepository();
        PersonService personService = new PersonService(personRepository);

        personService.validateClientAndAdd(firstClient);
        personService.validateClientAndAdd(secondClient);
        personService.validateEmployeeAndAdd(firstEmployee);
        personService.validateEmployeeAndAdd(secondEmployee);
        hotelService.validateAndAdd(firstHotel);
        hotelService.validateAndAdd(secondHotel);
        hotelService.validateAndAdd(thirdHotel);

        //this doesn't make sens - it's for homework purpose only
        Hotel [] hotelArray = hotelService.getHotels().toArray(new Hotel[hotelService.getHotels().size()]);
        //for to display the hotels in the above created array
        for (Hotel hotel : hotelArray){
            System.out.println("This is a hotel array: " + hotel.getName());
        }
        //separate the above for loop from the below for loop
        System.out.println();

        for (Hotel hotel : hotelService.getHotels()) {
            System.out.println("Name: " + hotel.getName());
            System.out.println("Max Capacity: " + hotel.getCapacity());
            System.out.println("Still has capacity? : " + hotel.isAvailable());
            System.out.println("Rating: " + hotel.getRating());
            System.out.print("Address: " + hotel.getStreetName());
            System.out.print(", " + hotel.getNumber());
            System.out.println(", " + hotel.getCity());
            System.out.println();
        }

        for (Person client : personService.getClients()) {
            System.out.println("Name: " + client.getClientName());
            System.out.println("E-mail: " + client.getClientEmail());
            System.out.println("Age: " + client.getClientAge());
            System.out.println("Gender: " + client.getGender());
            System.out.println();
        }

        for (Person employee : personService.getEmployees()) {
            System.out.println("Name: " + employee.getEmployeeName());
            System.out.println("Age: " + employee.getEmployeeAge());
            System.out.println("Gender: " + employee.getGender());
            System.out.println("Employee Number: " + employee.getEmployeeNumer());
            System.out.println();

            System.out.println(firstClient.getClientDetails());
            System.out.println(firstEmployee.getEmployeeDetails());
            System.out.println(firstHotel.toString());
        }
    }
}
