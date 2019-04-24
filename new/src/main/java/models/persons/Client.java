package models.persons;

import java.util.List;

public interface Client {

    String addClient(Person client);

    String removeClient(Person client);

    List<Person> listClients();
}
