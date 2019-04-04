package persons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionut on 4/4/2019.
 */
public class PersonList{

    private List<Client> clients = new ArrayList<Client>();
    private List<Employee> employees = new ArrayList<Employee>();

    public void addClient(Client client){
        clients.add(client);
    }

    public void removeClient(Client client){
        clients.remove(client);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public List<Client> getClients(){
        return clients;
    }

    public List<Employee> getEmployees(){
        return employees;
    }

}
