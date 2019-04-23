package models.persons;

import java.util.List;

public interface PersonInterface {

    String addClient(Person client);

    String removeClient(Person client);

    List<Person> listClients();

    String addEmployee(Person employee);

    String removeEmployee(Person employee);

    List<Person> listEmployee();


}

