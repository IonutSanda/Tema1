package models.persons;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements PersonInterface {

    private List<Person> clients = new ArrayList<>();
    private List<Person> employees = new ArrayList<>();


    @Override
    public String addEmployee(Person employee) {
        employees.add(employee);
        return "Employee has been added";
    }

    public String addClient(Person client) {
        clients.add(client);
        return "Client has been added";
    }


    @Override
    public String removeEmployee(Person employee) {
        employees.remove(employee);
        return "Employee has been removed";
    }

    @Override
    public String removeClient(Person client) {
        clients.remove(client);
        return "Client has been removed";
    }

    @Override
    public List<Person> listEmployee() {
        return employees;
    }

    @Override
    public List<Person> listClients() {
        return clients;
    }
}
