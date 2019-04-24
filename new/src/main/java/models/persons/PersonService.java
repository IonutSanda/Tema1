package models.persons;

import java.util.List;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @SuppressWarnings("deprecation")
    public String validateClientAndAdd(Person client) {

        if (client.getClientAge() < 18) {
            return "Client is underaged";
        }
        if (client.getClientName().equals("")) {
            return "Please enter the Clients name";
        }

        personRepository.addClient(client);
        return "Client has been added";
    }

    public void deleteClient(Person client) {
        personRepository.removeClient(client);
    }

    public String validateEmployeeAndAdd(Person employee) {
        if (employee.getEmployeeAge() < 21) {
            return "Employee is underaged";
        }
        if (employee.getEmployeeNumer().equals("")) {
            return "Employee Number is invalid";
        }

        personRepository.addEmployee(employee);
        return "Employee has been added";
    }

    public void deleteEmployee(Person employee) {
        personRepository.removeEmployee(employee);
    }

    public List<Person> getClients() {
        return personRepository.listClients();
    }

    public List<Person> getEmployees() {
        return personRepository.listEmployee();
    }

}
