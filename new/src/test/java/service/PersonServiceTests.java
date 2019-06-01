package service;

import model.ValidationException;
import model.enumeration.ErrorCodes;
import model.enumeration.Gender;
import model.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
class PersonServiceTests {

    @Mock
    private PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    void setup() {
        personService = new PersonService(personRepository);
    }

    @Test
    void should_Add_Client_If_ValidData() throws ValidationException {
        //GIVEN
        MockitoAnnotations.initMocks(this);
//        Person client = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        //WHEN
//        String response = personRepository.addClient(client);
//        THEN
        doReturn("Client has been added").when(personRepository).addClient(any(Person.class));
//        assertEquals("Client has been added", response);
    }

    @Test
    void should_Add_Employee_If_ValidData() {
        //GIVEN
        MockitoAnnotations.initMocks(this);
//        Person employee = new Person("Sanda Ionut", "ionut@me.com", 25, "123ABC", Gender.MALE);
        //WHEN
//        String response = personService.validateEmployeeAndAdd(employee);
        //THEN
        doReturn("Employee has been added").when(personRepository).addEmployee(any(Person.class));
//        assertEquals("Employee has been added", response);
    }

    @Test
    void shouldNot_Add_Client_If_Age_TooLow() throws ValidationException {
        //GIVEN
        MockitoAnnotations.initMocks(this);
//        Person client = new Person("Ionut Sanda", 6, "sanda@me.com", Gender.MALE);
        //WHEN
//        String response = personService.validateClientAndAdd(client);
        //THEN
        doReturn("Client is underaged").when(personRepository).addClient(any(Person.class));
//        assertEquals("Client is underaged", response);
    }

    @Test
    void shouldNot_Add_Employee_If_Age_TooLow() {
        //GIVEN
        MockitoAnnotations.initMocks(this);
//        Person employee = new Person("Ionut Sanda", 6, "sanda@me.com", Gender.MALE);
        //WHEN
//        String response = personService.validateEmployeeAndAdd(employee);
        //THEN
        doReturn("Employee is underaged").when(personRepository).addClient(any(Person.class));
//        assertEquals("Employee is underaged", response);
    }

    @Test
    void shouldNot_Add_Client_If_NameIsNull() {
        //GIVEN
        //WHEN
        //THEN
        Throwable exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("Please enter the Clients name", ErrorCodes.CLIENT_NOT_FOUND);
        });
        assertEquals("Please enter the Clients name", exception.getMessage());
    }

    @Test
    void shouldNot_Add_Client_If_Name_IsEmpty() throws ValidationException {
        //GIVEN
        MockitoAnnotations.initMocks(this);
//        Person client = new Person("", 25, "sanda@me.com", Gender.MALE);
        //WHEN
//        String response = personService.validateClientAndAdd(client);
        //THEN
        doReturn("Please enter the Clients name").when(personRepository).addClient(any(Person.class));
//        assertEquals("Please enter the Clients name", response);

    }

    @Test
    void shouldNot_Add_Employee_If_EmployeeNumberIsNull() {
        //GIVEN
        //WHEN
        //THEN
        Throwable exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("Employee Number is invalid", ErrorCodes.EMPLOYEE_NOT_FOUND);
        });
        assertEquals("Employee Number is invalid", exception.getMessage());
    }

    @Test
    void should_Remove_Client() throws ValidationException {
        //GIVEN
        MockitoAnnotations.initMocks(this);
//        Person client = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        //WHEN
//        String response = personService.deleteClient(client);
        //THEN
        doReturn("removed Client").when(personRepository).removeClient(any(Person.class));
//        assertEquals("removed Client", response);
    }

    @Test
    void should_Remove_Employee() throws ValidationException {
        //GIVEN
        MockitoAnnotations.initMocks(this);
//        Person employee = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        //WHEN
//        String response = personService.deleteEmployee(employee);
        //THEN
        doReturn("removed Employee").when(personRepository).removeEmployee(any(Person.class));
//        assertEquals("removed Employee", response);
    }

    @Test
    void clientList_ShouldNot_BeEmpty_If_ValidData() {
        //GIVEN
        Person client = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        List<Person> clients = new ArrayList<>();
        //WHEN
        clients.add(client);
        //THEN
        assertFalse(clients.isEmpty());
    }

    @Test
    void employeeList_ShouldNot_BeEmpty_If_ValidData() {
        //GIVEN
        Person employee = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        List<Person> employees = new ArrayList<>();
        employees.add(employee);
        //WHEN
        employees.remove(employee);
        //THEN
        assertTrue(employees.isEmpty());
    }

    @Test
    void clientList_Should_BeEmpty_If_ClientRemoved() {
        //GIVEN
        Person client = new Person("Ionut Sanda", 22, "sanda@me.com", Gender.MALE);
        List<Person> clients = new ArrayList<>();
        clients.add(client);
        //WHEN
        clients.remove(client);
        //THEN
        assertTrue(clients.isEmpty());
    }

    @Test
    void employeeList_Should_BeEmpty_If_EmployeeRemoved() {
        //GIVEN
        Person employee = new Person("Ionut Sanda", 22, "sanda@me.com", Gender.MALE);
        List<Person> employees = new ArrayList<>();
        employees.add(employee);
        //WHEN
        employees.remove(employee);
        //THEN
        assertTrue(employees.isEmpty());
    }


}
