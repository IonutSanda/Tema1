package model;

import model.building.Hotel;
import model.enumeration.Gender;
import model.enumeration.HasCapacity;
import model.person.Person;
import org.apache.log4j.Logger;
import repository.HotelRepository;
import repository.PersonRepository;
import service.HotelService;
import service.PersonService;

import java.io.*;

public class MainClass {

    /*
        - @Ignore annotation used in HotelServiceTests; ln. 44
        - assertThat used in HotelServiceTests; ln. 74
        - assertNotNull used in HotelServiceTests; ln. 81
        - @inheritDoc used in HotelRepository class.
        - Didn't upgrade to JUnit 5 due to some problems with (expected)
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

        for (Person employee : personService.getEmployees()) {
            logger.info("Name: " + employee.getEmployeeName());
            logger.info("Age: " + employee.getEmployeeAge());
            logger.info("Gender: " + employee.getGender());
            logger.info("Employee Number: " + employee.getEmployeeNumber());

            logger.info(firstClient.getClientDetails());
            logger.info(firstEmployee.getEmployeeDetails());
            logger.info(firstHotel.toString());
        }

        //Write using Try with Resources, the hotels into the HotelsOut.txt file
        try (FileWriter in = new FileWriter("HotelsIn.txt")) {
            for (Hotel hotel : hotelService.getHotels()) {
                in.write(String.valueOf(hotel) + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Write the hotels into the HotelsIn.txt file
        FileReader in;
        FileWriter out = null;

        try {
            in = new FileReader("HotelsIn.txt");
            out = new FileWriter("HotelsOut.txt");

            int value;
            while ((value = in.read()) != -1) {
                out.write(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Serialization of hotels
        String fileName = "Hotels.hot";
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            for (Hotel hotel : hotelService.getHotels()) {
                objectOutputStream.writeObject(hotel);
            }
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Serialized");

        //Deserialization of hotels
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            objectInputStream.readObject();
            logger.info("Deserialized");
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

