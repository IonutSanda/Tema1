package main;

import persons.Client;
import persons.Employee;
import persons.PersonList;

/**
 * Created by Ionut on 3/31/2019.
 */
public class MainClass {

    public static void main(String... args) {
        PersonList personList = new PersonList();

        Client firstClient = new Client("Ionut Sanda","test@me.com",25,'M');
        Client secondClient = new Client("Iulia Ferencz","me@test.com",27,'F');
        Client thirdClient = new Client("Cristina Popescu","testme@me.com",24,'F');
        Employee firstEmployee = new Employee("12345A","Sanda Ionut","ionut@ibis.ro",25,'M');
        Employee secondEmployee = new Employee("816518B","Ferencz Iulia","iulia@ibis.ro",27,'F');
        Employee thirdEmployee = new Employee("290342C","Popescu Cristina","cristina@ibis.ro",24,'F');

        personList.addClient(firstClient);
        personList.addClient(secondClient);
        personList.addClient(thirdClient);
        personList.addEmployee(firstEmployee);
        personList.addEmployee(secondEmployee);
        personList.addEmployee(thirdEmployee);

        for (Client client : personList.getClients()){
            System.out.println("Client " + client);
        }
        System.out.println();

        for (Employee employee : personList.getEmployees()){
            System.out.println("Employee " + employee);
        }

        personList.removeClient(thirdClient);
        personList.removeEmployee(thirdEmployee);

        System.out.println("Print after Client and Employee were removed");
        System.out.println();

        for (Client client : personList.getClients()){
            System.out.println("Client: " + client);
        }

        for (Employee employee : personList.getEmployees()){
            System.out.println("Client: " + employee);
        }


    }
}
