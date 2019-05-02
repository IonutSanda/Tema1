package model;

import model.building.*;
import model.enumaration.Gender;
import model.enumaration.HasCapacity;
import model.person.Person;
import repository.HotelRepository;
import repository.PersonRepository;
import service.HotelService;
import service.PersonService;
import org.apache.log4j.Logger;

public class MainClass {

    /*
    - Address class has been excluded from the building package to be able to use protected access modifier.
    - toString(), and deprecated is located in Hotel Class.
    - suppressWarning is used in HotelService.
    - default access modifier not used. Need help where to use it.
    - DoNothing and Verify has been added in HotelServiceTests - nu stiu ce am facut pe acolo - but it works
    - Custom exceptions used - NPE is in PersonServiceTests.java.
    - DEBUG and ERROR Logger have been added in Hotel Repository
    - ERROR logs only the error logger not the debug and info.
    - I had to use @RunWith(MockitoJUnitRunner.Silent.class) instead of the normal @RunWith (MockitoJUnitRunner.class) - i don't know why
    */

    private static Logger logger = Logger.getLogger(MainClass.class);

    public static void main(String[] args) throws ValidationException {

        Hotel firstHotel = new Hotel("Ibis", 150, 1.5, "Ibis Street", 25, "Cluj", HasCapacity.NO_CAPACITY);
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
        Hotel[] hotelArray = hotelService.getHotels().toArray(new Hotel[hotelService.getHotels().size()]);
        //for to display the hotels in the above created array

        for (Hotel hotel : hotelArray){
            logger.info("This is a hotel array: " + hotel.getName());
        }

        for (Hotel hotel : hotelService.getHotels()) {
            logger.info("Name: " + hotel.getName());
            logger.info("Max Capacity: " + hotel.getCapacity());
            logger.info("Still has capacity? : " + hotel.isAvailable());
            logger.info("Rating: " + hotel.getRating());
            logger.info("Address: " + hotel.getStreetName() + ", " + hotel.getName() + ", " + hotel.getCity());
        }

        for (Person client : personService.getClients()) {
            logger.info("Name: " + client.getClientName());
            logger.info("E-mail: " + client.getClientEmail());
            logger.info("Age: " + client.getClientAge());
            logger.info("Gender: " + client.getGender());
        }

        for (Person employee : personService.getEmployees()) {
            logger.info("Name: " + employee.getEmployeeName());
            logger.info("Age: " + employee.getEmployeeAge());
            logger.info("Gender: " + employee.getGender());
            logger.info("Employee Number: " + employee.getEmployeeNumber());

            logger.info(firstClient.getClientDetails());
            logger.info(firstEmployee.getEmployeeDetails());
            logger.info(firstHotel.toString());

        }
    }
}
