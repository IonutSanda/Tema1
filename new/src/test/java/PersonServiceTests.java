import models.persons.Gender;
import models.persons.Person;
import models.persons.PersonRepository;
import models.persons.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
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

}
