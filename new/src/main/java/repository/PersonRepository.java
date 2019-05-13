package repository;

import model.ValidationException;
import model.person.Client;
import model.person.Employee;
import model.person.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Client, Employee {

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
    public String removeEmployee(Person employee) throws ValidationException {
        if (employees.size() == 0) {
            throw new ValidationException("There are no employees to remove");
        }
        employees.remove(employee);
        return "Employee has been removed";
    }

    @Override
    public String removeClient(Person client) throws ValidationException {
        if (clients.size() == 0) {
            throw new ValidationException("There are no clients to remove");
        }
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
