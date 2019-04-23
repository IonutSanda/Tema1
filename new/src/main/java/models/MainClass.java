package models;

import models.buildings.Hotel;
import models.buildings.HotelRepository;
import models.buildings.HotelService;
import models.persons.Person;
import models.persons.PersonRepository;
import models.persons.PersonService;

public class MainClass {

    public static void main(String[] args) {

        Hotel firstHotel = new Hotel("Ibis", 50, 4.3, "Ibis Street", 25, "Cluj");
        Hotel secondHotel = new Hotel("Hilton", 250, 2, "Hilton Street", 88, "Cluj");
        Hotel thirdHotel = new Hotel("Ramada and CO", 300, 4.7, "Ramada Street", 12, "Cluj");

        Person firstClient = new Person("Ionut Sanda", 28, "sanda@me.com");
        Person firstEmployee = new Person("Sanda Ionut", "ionut@me.com", 27, "123ABC");

        Person secondClient = new Person("Iulia Ferencz", 27, "iulia@me.com");
        Person secondEmployee = new Person("Ferencz Iulia", "ferencz@me.com", 26, "4321CBA");

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

        for (Hotel hotel : hotelService.getHotels()) {
            System.out.println("Name: " + hotel.getName());
            System.out.println("Capacity: " + hotel.getCapacity());
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
            System.out.println();
        }

        for (Person employee : personService.getEmployees()) {
            System.out.println("Name: " + employee.getEmployeeName());
            System.out.println("Age: " + employee.getEmployeeAge());
            System.out.println("Employee Number: " + employee.getEmployeeNumer());
            System.out.println();

            System.out.println(firstClient.getClientDetails());
            System.out.println(firstEmployee.getEmployeeDetails());
            System.out.println(firstHotel.toString());
        }
    }
}
