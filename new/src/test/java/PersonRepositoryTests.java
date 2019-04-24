import models.persons.Gender;
import models.persons.Person;
import models.persons.PersonRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonRepositoryTests {

    private PersonRepository personRepository;

    @Before
    public void setup(){
        personRepository = new PersonRepository();
    }

    @Test
    public void should_Add_Client_If_ValidData(){
        //GIVEN
        Person client = new Person("Ionut Sanda",27,"sanda@me.com",Gender.MALE);
        //WHEN
        String response = personRepository.addClient(client);
        //THEN
        assertEquals("Client has been added",response);
    }
    @Test
    public void should_Add_Employee_If_ValidData(){
        //GIVEN
        Person employee = new Person("Ionut Sanda","ionut@me.com",27,"123ABC",Gender.MALE);
        //WHEN
        String response = personRepository.addEmployee(employee);
        //THEN
        assertEquals("Employee has been added",response);
    }

    @Test
    public void should_Delete_Client(){
        //GIVEN
        Person client = new Person ("Ionut Sanda",27,"sanda@me.com",Gender.MALE);
        //WHEN
        String response = personRepository.removeClient(client);
        //THEN
        assertEquals("Client has been removed",response);
    }
    @Test
    public void should_Delete_Employee(){
        //GIVEN
        Person employee = new Person("Ionut Sanda","ionut@me.com",27,"123ABC",Gender.MALE);
        //WHEN
        String response = personRepository.removeEmployee(employee);
        //THEN
        assertEquals("Employee has been removed",response);
    }

    @Test
    public void client_List_ShouldNot_BeEmpty_If_ClientAdded(){
        //GIVEN
        Person client = new Person("Ionut Sanda",27,"sanda@me.com",Gender.MALE);
        List<Person> clients = new ArrayList<>();
        //WHEN
        clients.add(client);
        //THEN
        assertFalse(clients.isEmpty());
    }
    @Test
    public void client_List_Should_BeEmpty_If_ClientRemoved(){
        //GIVEN
        Person client = new Person("Ionut Sanda",27,"sanda@me.com",Gender.MALE);
        List<Person> clients = new ArrayList<>();
        clients.add(client);
        //WHEN
        clients.remove(client);
        //THEN
        assertTrue(clients.isEmpty());

    }

}
