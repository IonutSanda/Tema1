package main;

import hotelandpersonlist.HotelsList;
import hotelandpersonlist.PersonsList;
import persons.Client;
import persons.Employee;
/**
 * Created by Ionut on 3/31/2019.
 */
public class MainClass {

    public static void main(String[] args) {

        PersonsList personsList = new PersonsList();
        HotelsList hotelList = new HotelsList();

        Client firstClient = new Client("Sanda Ionut","sanda@me.com",24,'M');
        Client secondClient = new Client("Ferencz Iulia","ferencz@me.com",27,'F');
        Client thirdClient = new Client("Pop Andrea","pop@me.com",26,'F');
        Employee firstEmployee = new Employee("Ionut Sanda","123456A",24,'M');
        Employee secondEmployee = new Employee("Ferencz Iulia","198613B",27,'F');
        Employee thirdEmployee = new Employee("Pop Andrea","BA12586",26,'F');

        personsList.addClient(firstClient);
        personsList.addClient(secondClient);
        personsList.addClient(thirdClient);
        personsList.addEmployee(firstEmployee);
        personsList.addEmployee(secondEmployee);
        personsList.addEmployee(thirdEmployee);

        for (Client client : personsList.getClients()){
            System.out.println(client);
        }

        for (Employee employee : personsList.getEmployees()){
            System.out.println(employee);
        }
        personsList.removeEmployee(thirdEmployee);
        personsList.removeClient(thirdClient);
        System.out.println();
        System.out.println("Printer after an Employee and Client got removed");

        for (Client client : personsList.getClients()){
            System.out.println(client);
        }
        for (Employee employee : personsList.getEmployees()){
            System.out.println(employee);
        }


    }
}
