package model.person;

import model.ValidationException;

import java.util.List;

public interface Employee {

    String addEmployee(Person employee);

    String removeEmployee(Person employee) throws ValidationException;

    List<Person> listEmployee();
}
