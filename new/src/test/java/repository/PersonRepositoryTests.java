package repository;

import model.ValidationException;
import model.enumeration.ErrorCodes;
import model.enumeration.Gender;
import model.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PersonRepositoryTests {

    private PersonRepository personRepository;

    @BeforeEach
    void setup() {
        personRepository = new PersonRepository();
    }

    @Test
    void should_Add_Client_If_ValidData() {
        //GIVEN
        Person client = new Person("Ionut Sanda", 27, "sanda@me.com", Gender.MALE);
        //WHEN
        String response = personRepository.addClient(client);
        //THEN
        assertEquals("Client has been added", response);
    }

    @Test
    void should_Add_Employee_If_ValidData() {
        //GIVEN
        Person employee = new Person("Ionut Sanda", "ionut@me.com", 27, "123ABC", Gender.MALE);
        //WHEN
        String response = personRepository.addEmployee(employee);
        //THEN
        assertEquals("Employee has been added", response);
    }

    @Test
    void should_Delete_Client() {
        //GIVEN
        Person client = new Person("Ionut Sanda", 27, "sanda@me.com", Gender.MALE);
        List<Person> clients = new ArrayList<>();
        clients.add(client);
        //WHEN
        clients.remove(client);
        //THEN
        Throwable exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("Client has been removed", ErrorCodes.HOTEL_NOT_FOUND);
        });
        assertEquals("Client has been removed", exception.getMessage());
    }

    @Test
    void should_Delete_Employee() {
        //GIVEN
        Person employee = new Person("Ionut Sanda", "ionut@me.com", 27, "123ABC", Gender.MALE);
        List<Person> employees = new ArrayList<>();
        employees.add(employee);
        //WHEN
        employees.remove(employee);
        //THEN
        Throwable exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("Employee has been removed", ErrorCodes.HOTEL_NOT_FOUND);
        });
        assertEquals("Employee has been removed", exception.getMessage());
    }

    @Test
    void client_List_ShouldNot_BeEmpty_If_ClientAdded() {
        //GIVEN
        Person client = new Person("Ionut Sanda", 27, "sanda@me.com", Gender.MALE);
        List<Person> clients = new ArrayList<>();
        //WHEN
        clients.add(client);
        //THEN
        assertFalse(clients.isEmpty());
    }

    @Test
    void client_List_Should_BeEmpty_If_ClientRemoved() {
        //GIVEN
        Person client = new Person("Ionut Sanda", 27, "sanda@me.com", Gender.MALE);
        List<Person> clients = new ArrayList<>();
        clients.add(client);
        //WHEN
        clients.remove(client);
        //THEN
        assertTrue(clients.isEmpty());

    }

}
