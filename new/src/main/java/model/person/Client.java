package model.person;

import model.ValidationException;

import java.util.List;

/**
 * Here are the methods defined to add, remove and List the Clients
 * which will be added through the MainClass
 */
public interface Client {

    /**
     * Add the client to a created list
     *
     * @param client - Client which will be added
     * @return returns a String if the client has been added
     */
    String addClient(Person client);

    /**
     * Remove the client, which was added, from a created list
     *
     * @param client - Client which will be added
     * @return returns a String if the client has been deleted
     * @throws ValidationException - this is a custom exception which will throw a custom message
     *                             if the client can not be removed; Reason why it can not be removed
     *                             is that there are no clients to remove from the list4
     */
    String removeClient(Person client) throws ValidationException;

    /**
     * Display the clients which were added to the created list
     *
     * @return returns the list of the clients
     */
    List<Person> listClients();
}
