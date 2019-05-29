import model.ValidationException;
import model.building.Hotel;
import model.building.HotelBuilder;
import model.building.HotelBuilderLombok;
import model.enumeration.Gender;
import model.enumeration.HasCapacity;
import model.person.Person;
import model.person.RandomNumberGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.HotelRepository;
import repository.PersonRepository;
import service.HotelService;
import service.PersonService;

import java.util.Arrays;
import java.util.List;

import static model.IOHandling.*;
import static model.StreamHandling.CreateStreamAndUseFunctions;
import static model.StreamHandling.SetAndMap;

public class MainClass {

/*
    - created a stream from a collection and applied the following: (in this order)
        - filter, map, sorted, collect, forEach, min, isPresent, get, max, ifPresent, reduce, count, anyMatch
        - extracted the Stream Handling / Manipulation into a separate Class named "StreamHandling"
    - created two different classes (to not rebuild the project) for using builders
        - HotelBuilder class uses the manually build Builder
        - HotelBuilderLombok class uses the Lombok Builder
    - Created an Enum for Errorcdes to be used in Tests and not only
    - Adapted the code for using the ErrorCodes - need some help, since the ErrorCode isn't showing.
    - Removed all System.out.println from project
    - Added Placeholder in HotelInterface
    - Updated the Logger with log4j2
    - Cleaned the junit imports - only jupiter imports are left
*/

    //    private static Class<Logger> logger = Logger.class;
    private static Logger logger = LogManager.getLogger(MainClass.class);


    public static void main(String[] args) throws ValidationException {


        Hotel firstHotel = new Hotel("Ibis", 150, 4.5, "Ibis Street", 25, "Cluj", HasCapacity.NO_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        Hotel secondHotel = new Hotel("Hilton", 250, 1.5, "Hilton Street", 88, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        Hotel thirdHotel = new Hotel("Ramada and CO", 300, 4.7, "Ramada Street", 12, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());

        Person firstClient = new Person("Ionut Sanda", 28, "sanda@me.com", Gender.MALE);
        Person secondClient = new Person("Iulia Ferencz", 27, "iulia@me.com", Gender.FEMALE);


        //mocking reasons for creating a new repo
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);
        PersonRepository personRepository = new PersonRepository();
        PersonService personService = new PersonService(personRepository);

        //Set and Map
        SetAndMap();
        CreateStreamAndUseFunctions();

        //IO Handling
        tryWithResources(hotelService);
        tryWithoutResources();
        String fileName = hotelSerialization(hotelService);
        hotelDeserialization(fileName);

        personService.validateClientAndAdd(firstClient);
        personService.validateClientAndAdd(secondClient);
        hotelService.validateAndAdd(firstHotel);
        hotelService.validateAndAdd(secondHotel);
        hotelService.validateAndAdd(thirdHotel);

        //New method in PersonService class called getClientsList where I used a wildcard
        List<?> clientsNew = Arrays.asList(firstClient, secondClient);
        personRepository.getClientsList(clientsNew);

        //this doesn't make sens - it's for homework purpose only
        Hotel[] hotelArray = hotelService.getHotels().toArray(new Hotel[hotelService.getHotels().size()]);
        //for to display the hotels in the above created array
        for (Hotel hotel : hotelArray) {
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

        for (Person forEmployee : personService.getEmployees()) {
            logger.info("Name: " + forEmployee.getEmployeeName());
            logger.info("Age: " + forEmployee.getEmployeeAge());
            logger.info("Gender: " + forEmployee.getGender());
            logger.info("Employee Number: " + forEmployee.getEmployeeNumber());

            logger.info(firstClient.getClientDetails());
            logger.info(forEmployee.getEmployeeDetails());
            logger.info(firstHotel.toString());
        }


        HotelBuilder hotelBuilder = new HotelBuilder("The Building").setCapacity(200).setRating(4.5).setHasCapacity(HasCapacity.HAS_CAPACITY).setId(RandomNumberGenerator.hotelNumberGenerator()).build();
        logger.info(hotelBuilder);

        logger.info(HotelBuilderLombok.builder()
                .name("The Lombok Building")
                .capacity(200)
                .rating(4.7)
                .hasCapacity(HasCapacity.HAS_CAPACITY)
                .id(RandomNumberGenerator.hotelNumberGenerator())
                .build());
    }

}
