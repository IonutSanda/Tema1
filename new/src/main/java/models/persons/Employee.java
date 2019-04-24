package models.persons;

import java.util.List;

public interface Employee {

    String addEmployee(Person employee);

    String removeEmployee(Person employee);

    List<Person> listEmployee();
}
