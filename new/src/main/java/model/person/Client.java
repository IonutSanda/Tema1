package model.person;

import model.ValidationException;

import java.util.List;

public interface Client {

    String addClient(Person client);

    String removeClient(Person client) throws ValidationException;

    List<Person> listClients();
}
