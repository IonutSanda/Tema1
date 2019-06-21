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

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static handling.IOHandling.*;
import static handling.StreamHandling.CreateStreamAndUseFunctions;
import static handling.StreamHandling.SetAndMap;
import static jdbc.JDBConnection.newConnection;

public class MainClass {

    private static Logger logger = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) throws ValidationException {

        Hotel firstHotel = new Hotel("Ibis", 150, 4.5, "Ibis Street", 25, "Cluj", HasCapacity.NO_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        Hotel secondHotel = new Hotel("Hilton", 250, 1.5, "Hilton Street", 88, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        Hotel thirdHotel = new Hotel("Ramada and CO", 300, 4.7, "Ramada Street", 12, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        Hotel forthHotel = new Hotel("Castel and CO", 200, 4.7, "Castel Street", 32, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());
        Hotel fifthHotel = new Hotel("Hotel and CO", 350, 4.7, "Hotel Street", 2, "Cluj", HasCapacity.HAS_CAPACITY, RandomNumberGenerator.hotelNumberGenerator());

        Person firstClient = new Person("Ionut Sanda", 28, "sanda@me.com", Gender.MALE);
        Person secondClient = new Person("Iulia Ferencz", 27, "iulia@me.com", Gender.FEMALE);
        Person thirdClient = new Person("Marin Sanda", 47, "marin@me.com", Gender.MALE);
        Person forthClient = new Person("Iuliu Ferencz", 55, "iuliu@me.com", Gender.MALE);
        Person fifthClient = new Person("Alin Sanda", 37, "alin@me.com", Gender.MALE);

        //mocking reasons for creating a new repo
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);
        PersonRepository personRepository = new PersonRepository();
        PersonService personService = new PersonService(personRepository);

        //Set and Map
        SetAndMap();
        CreateStreamAndUseFunctions();

//        IO Handling
        tryWithResources(hotelService);
        tryWithoutResources();
        String fileName = hotelSerialization(hotelService);
        hotelDeserialization(fileName);

        personService.validateClientAndAdd(firstClient);
        personService.validateClientAndAdd(secondClient);
        personService.validateClientAndAdd(thirdClient);
        personService.validateClientAndAdd(forthClient);
        personService.validateClientAndAdd(fifthClient);
        hotelService.validateAndAdd(firstHotel);
        hotelService.validateAndAdd(secondHotel);
        hotelService.validateAndAdd(thirdHotel);
        hotelService.validateAndAdd(forthHotel);
        hotelService.validateAndAdd(fifthHotel);

        //New method in PersonService class called getClientsList where I used a wildcard
        List<?> clientsNew = Arrays.asList(firstClient, secondClient);
        personRepository.getClientsList(clientsNew);

//        this doesn't make sens - it's for homework purpose only
        Hotel[] hotelArray = hotelService.getHotels().toArray(new Hotel[hotelService.getHotels().size()]);
//        for to display the hotels in the above created array
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

//        for (Person client : personService.getClients()) {
//            logger.info("Name: " + client.getClientName());
//            logger.info("E-mail: " + client.getClientEmail());
//            logger.info("Age: " + client.getClientAge());
//            logger.info("Gender: " + client.getGender());
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(RandomNumberGenerator.randomSleepTime());
//                        hotelService.checkIn(client, hotelService.getRandomHotel());
//                        logger.info("Client: " + client.getClientName() + " has checked in at: " + new CheckInData().getTime() + " on " + new CheckInData().getDate());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }

        for (Person forEmployee : personService.getEmployees()) {
            logger.info("Name: " + forEmployee.getEmployeeName());
            logger.info("Age: " + forEmployee.getEmployeeAge());
            logger.info("Gender: " + forEmployee.getGender());
            logger.info("Employee Number: " + forEmployee.getEmployeeNumber());

            logger.info(firstClient.getClientDetails());
            logger.info(forEmployee.getEmployeeDetails());
            logger.info(firstHotel.toStringList());
        }
//
//
        HotelBuilder hotelBuilder = new HotelBuilder("The Building").setCapacity(200).setRating(4.5).setHasCapacity(HasCapacity.HAS_CAPACITY).setId(RandomNumberGenerator.hotelNumberGenerator()).build();
        logger.info(hotelBuilder);

        logger.info(HotelBuilderLombok.builder()
                .name("The Lombok Building")
                .capacity(200)
                .rating(4.7)
                .hasCapacity(HasCapacity.HAS_CAPACITY)
                .id(RandomNumberGenerator.hotelNumberGenerator())
                .build());

        try {

        System.out.println("Enter the Database Password: ");
        String enteredPassword = new Scanner(System.in).next();

        Connection connection = newConnection(
                "localhost",
                "5432",
                "homework9",
                "postgresql",
                "postgres",
                enteredPassword
        );

        /*
         When creating the connection the autocommit is set to true by default
         Setting the autocommit basically lets you execute more statements in the same transaction
         Another advantage for setting autocommit to false is that if at least one of your statements aren't executed successfully
         neither will be executed, hence a rollback to the initial state will be done
         The code block below is commented because of the following reasons:
            - it will throw and error because the database already exists
            - when creating the connection you need to state which database are you connecting to
         */
//        PreparedStatement createDataBase =
//            connection.prepareStatement("create database homework9;");
//        createDataBase.execute();

        /*
        Setting the autocommit to false lets me execute more statements in a single transaction and
        making sure that these are executed properly before committing them
        */
        try {
            assert connection != null;
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

            PreparedStatement createTable =
                connection.prepareStatement("create table if not exists hotels (id serial, name varchar(64), rating decimal, capacity int, availability boolean)");
                createTable.execute();
                connection.commit();

            for (int i = 1; i <= 10; i++) {
                connection.prepareStatement("insert into hotels (name, rating, capacity, availability) values ('Ramada', '4.5', '250', 'false')").execute();
                connection.prepareStatement("insert into hotels (name, rating, capacity, availability) values ('Hilton', '4.7', '350', 'true')").execute();
                connection.prepareStatement("insert into hotels (name, rating, capacity, availability) values ('Ibis', '4.8', '210', 'true')").execute();
                connection.commit();
            }

            //added a restart statement for the id - TEST PURPOSE ONLY
            connection.prepareStatement("alter sequence hotels_id_seq restart with 1").execute();
            connection.commit();

            PreparedStatement deleteFromHotels =
                connection.prepareStatement("delete from Hotels where availability = ?");
                deleteFromHotels.setBoolean(1, false);
                deleteFromHotels.execute();
                connection.commit();

            PreparedStatement updateHotels =
                connection.prepareStatement("update Hotels set name = ?, rating = ?, capacity = ?, availability = ? where id = ?");
                updateHotels.setString(1, "AlexanderHotel");
                updateHotels.setDouble(2, 3.5);
                updateHotels.setInt(3, 400);
                updateHotels.setBoolean(4, false);
                updateHotels.setInt(5, 11);
                updateHotels.execute();
                connection.commit();

        Statement getDataHotel = connection.createStatement();
        ResultSet resultSet2 = getDataHotel.executeQuery("select id, name, capacity from hotels");

        List<Hotel> hotelListClass = new ArrayList<>();

        while (resultSet2.next()){
            Hotel hotelList = new Hotel();

            hotelList.setIdList(resultSet2.getInt(1));
            hotelList.setNameList(resultSet2.getString(2));
            hotelList.setCapacityList(resultSet2.getInt(3));

            hotelListClass.add(hotelList);
        }

        hotelListClass.forEach(System.out::println);
    } catch (SQLException e){
        e.printStackTrace();
        }
    }

}




