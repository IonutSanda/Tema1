package model;

import model.building.Hotel;
import model.enumeration.Gender;
import model.enumeration.HasCapacity;
import model.person.Person;
import model.person.RandomNumberGenerator;
import org.apache.log4j.Logger;
import repository.HotelRepository;
import repository.PersonRepository;
import service.HotelService;
import service.PersonService;

import java.util.*;

import static model.IOHandling.*;

public class MainClass {

/*
    - tried adding org.apache.logging.log4j/log4j-core - not successful due to 'getLogger' error - can not resolve it
    - IO Handling was extracted to functions and created a different class (IOHandling)
    - didn't use @ToString from Lombok, because the build ToString is custom
    - added Lombok
    - code cleaning (getting rid of Setters, Getters, declared same type variables on one line, etc)
    - Set and Map added in main: ln 41
    - created 2 different kind of comparators and used it for sorting
    - Wildcard used in PersonService class - it doesn't make any sense to use it in my project - but I had to.
*/

    private static Logger logger = Logger.getLogger(MainClass.class);

    public static void main(String[] args) throws ValidationException {


        Hotel firstHotel = new Hotel("Ibis", 150, 1.5, "Ibis Street", 25, "Cluj", HasCapacity.NO_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        Hotel secondHotel = new Hotel("Hilton", 250, 5, "Hilton Street", 88, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        Hotel thirdHotel = new Hotel("Ramada and CO", 300, 4.7, "Ramada Street", 12, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());

        Person firstClient = new Person("Ionut Sanda", 28, "sanda@me.com", Gender.MALE);
        Person secondClient = new Person("Iulia Ferencz", 27, "iulia@me.com", Gender.FEMALE);

        SetAndMap();

        //mocking reasons for creating a new repo
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);
        PersonRepository personRepository = new PersonRepository();
        PersonService personService = new PersonService(personRepository);

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

        tryWithResources(hotelService);
        tryWithoutResources();

        String fileName = hotelSerialization(hotelService);
        hotelDeserialization(fileName);

    }

    //Not sure if the body is correctly structured
    private static void SetAndMap() {

        //- RandomNumberGenerator is set to 2 digits for duplicate purpose
        Comparator<Person> sortByName =
                Comparator.comparing(Person::getEmployeeNumber);

        /* FOR EXERCISE PURPOSE ONLY !!! */
//        Comparator<Person> sortByNameNew =
//                (employee1, employee2) -> employee1.getEmployeeNumber().compareTo(employee2.getEmployeeNumber());

        Set<Person> personSet = new HashSet<>();
        Map<UUID, Hotel> hotelMap = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
            Person person = new Person("Sanda Ionut", "Ionut@me.com", 27, RandomNumberGenerator.employeeNumberGenerator(), Gender.MALE);
            Hotel hotel = new Hotel("Ibis", 150, 4.5, "Ibis Street", 25, "Cluj", HasCapacity.NO_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
            logger.info("Person " + i + ": " + person.getEmployeeDetails());
            personSet.add(person);
            hotelMap.put(RandomNumberGenerator.hotelNumberGenerator(), hotel);
        }
        //- the System.out.println is there just to verify the set size (to make sure it didn't add 20 - high probability of duplicate values)
        System.out.println("Size of the Set: " + personSet.size());
        System.out.println("Size of the Map: " + hotelMap.size());

        //Create a list from the set to be able to sort it
        List<Person> listFromSet = new ArrayList<>(personSet);
        listFromSet.sort(sortByName);

        for (Person personList : listFromSet) {
            logger.info("Ordered list: " + personList.getEmployeeNumber());
        }

        //Map
        for (Map.Entry entry : hotelMap.entrySet()) {
            Hotel hotelMapShow = (Hotel) entry.getValue();
            logger.info(hotelMapShow.getId());
        }
    }
}

