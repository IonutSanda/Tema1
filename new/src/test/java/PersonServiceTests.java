import models.persons.Gender;
import models.persons.Person;
import models.persons.PersonRepository;
import models.persons.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTests {

    @Mock
    private PersonRepository personRepository;
    private PersonService personService;

    @Before
    public void setup(){
        personService = new PersonService(personRepository);
    }

    @Test
    public void should_Add_Client_If_ValidData() {
        //GIVEN
        Person client = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        doReturn("Client has been added").when(personRepository).addClient(any(Person.class));
        //WHEN
        String response = personService.validateClientAndAdd(client);
        //THEN
        assertEquals("Client has been added", response);
    }
    @Test
    public void should_Add_Employee_If_ValidData(){
        //GIVEN
        Person employee = new Person("Sanda Ionut","ionut@me.com",25,"123ABC", Gender.MALE);
        doReturn("Employee has been added").when(personRepository).addEmployee(any(Person.class));
        //WHEN
        String response = personService.validateEmployeeAndAdd(employee);
        //THEN
        assertEquals("Employee has been added",response);
    }

    @Test
    public void shouldNot_Add_Client_If_Age_TooLow(){
        //GIVEN
        Person client = new Person("Ionut Sanda", 6, "sanda@me.com", Gender.MALE);
        //WHEN
        String response = personService.validateClientAndAdd(client);
        //THEN
        assertEquals("Client is underaged", response);
    }
    @Test
    public void shouldNot_Add_Employee_If_Age_TooLow(){
        //GIVEN
        Person employee = new Person("Ionut Sanda", 6, "sanda@me.com", Gender.MALE);
        //WHEN
        String response = personService.validateEmployeeAndAdd(employee);
        //THEN
        assertEquals("Employee is underaged",response);
    }

    @Test(expected = NullPointerException.class)
    public void shouldNot_Add_Client_If_NameIsNull(){
        //GIVEN
        //WHEN
        String response = personService.validateClientAndAdd(null);
        //THEN
        assertEquals("Please enter the Clients name",response);
    }
    @Test
    public void shouldNot_Add_Client_If_Name_IsEmpty(){
        //GIVEN
        Person client = new Person("", 25, "sanda@me.com", Gender.MALE);
        //WHEN
        String response = personService.validateClientAndAdd(client);
        //THEN
        assertEquals("Please enter the Clients name", response);

    }
    @Test(expected = NullPointerException.class)
    public void shouldNot_Add_Employee_If_EmployeeNumberIsNull(){
        //GIVEN
        //WHEN
        String response = personService.validateEmployeeAndAdd(null);
        //THEN
        assertEquals("Employee Number is invalid", response);
    }

    @Test
    public void should_Remove_Client(){
        //GIVEN
        Person client = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        //WHEN
        String response = personService.deleteClient(client);
        //THEN
        assertEquals("removed Client", response);
    }
    @Test
    public void should_Remove_Employee(){
        //GIVEN
        Person employee = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        //WHEN
        String response = personService.deleteEmployee(employee);
        //THEN
        assertEquals("removed Employee",response);
    }

    @Test
    public void clientList_ShouldNot_BeEmpty_If_ValidData(){
        //GIVEN
        Person client = new Person("Ionut Sanda", 25, "sanda@me.com", Gender.MALE);
        List<Person> clients = new ArrayList<>();
        //WHEN
        clients.add(client);
        //THEN
        assertFalse(clients.isEmpty());
    }
    @Test
    public void employeeList_ShouldNot_BeEmpty_If_ValidData(){
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
    public void clientList_Should_BeEmpty_If_ClientRemoved(){
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
    public  void employeeList_Should_BeEmpty_If_EmployeeRemoved(){
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
