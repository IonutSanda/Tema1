package hotelandpersonlist;

import persons.Client;
import persons.Employee;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Ionut on 3/31/2019.
 */
public class PersonsList {

    protected List<Client> clients = new ArrayList<Client>();
    protected List<Employee> employees = new ArrayList<Employee>();

    public void addClient(Client client){
        clients.add(client);
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeClient(Client client){
        clients.remove(client);
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
