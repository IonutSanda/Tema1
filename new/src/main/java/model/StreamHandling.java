package model;

import model.building.Hotel;
import model.enumeration.Gender;
import model.enumeration.HasCapacity;
import model.person.Person;
import model.person.RandomNumberGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class StreamHandling {

    private static Logger logger = LogManager.getLogger(StreamHandling.class);

    public static void CreateStreamAndUseFunctions() {
        Comparator<Person> getYoungestEmployee =
                Comparator.comparingInt(Person::getClientAge);
        Comparator<Person> getHighestEmployeeNumber =
                Comparator.comparing(Person::getEmployeeNumber);

        Comparator<Person> sortByEmployeeNumber =
                Comparator.comparing(Person::getEmployeeNumber);

        Set<Person> personSetFunctions = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            Person person = new Person("Iulia Ferencz", "iulia@me.com", 28 + i, RandomNumberGenerator.employeeNumberGenerator(), Gender.FEMALE);
            personSetFunctions.add(person);
        }

        personSetFunctions.stream()
                .filter(age -> age.getEmployeeAge() % 2 == 0)
                .sorted(sortByEmployeeNumber)
                .map(details -> details.getEmployeeDetails().toUpperCase())
                .collect(Collectors.toList())
                .forEach(logger::info);

        Optional<Person> youngestEmployee = personSetFunctions.stream()
                .min(getYoungestEmployee);

        if (youngestEmployee.isPresent()) {
            logger.info("Youngest Employee is: " + youngestEmployee.get());
        } else {
            logger.info("There are no employees");
        }

        Optional<Person> highestEmployeeNumber = personSetFunctions.stream()
                .max(getHighestEmployeeNumber);
        highestEmployeeNumber.ifPresent(logger::info);


        Optional<Person> oldestEmployee = personSetFunctions.stream()
                .reduce((employee1, employee2) ->
                        employee1.getEmployeeAge() > employee2.getEmployeeAge() ? employee1 : employee2);
        oldestEmployee.ifPresent(logger::info);

        //I could have just used .size directly on the list - but homework is homework.
        int countEmployees = (int) personSetFunctions.stream().count();

        logger.info(countEmployees);

        boolean ageDividedBy5 = personSetFunctions.stream()
                .anyMatch(divided -> divided.getEmployeeAge() % 5 == 0);
        logger.info(ageDividedBy5);
    }

    //Not sure if the body is correctly structured
    public static void SetAndMap() {

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
        // the System.out.println is here for test purpose only
//        System.out.println("Size of the Set: " + personSet.size());
//        System.out.println("Size of the Map: " + hotelMap.size());

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
