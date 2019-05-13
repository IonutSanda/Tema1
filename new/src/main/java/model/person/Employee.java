package model.person;

import model.ValidationException;

import java.util.List;

/**
 * Here are the methods defined to add, remove and List the Employees
 * which will be added through the MainClass
 */

public interface Employee {

    /**
     * Add the employee to a created list
     *
     * @param employee - Employee which will be added
     * @return returns a String of an Employee was added
     */
    String addEmployee(Person employee);

    /**
     * Remove the employee, which was added, from a created list
     *
     * @param employee - Employee which will be added
     * @throws ValidationException - this is a custom exception which will throw a custom message
     *                             if the employee can not be removed; Reason why it can not be removed
     *                             is that there are no employees to remove from the list
     * @return returns a String if the Employee has been successfully deleted
     */
    String removeEmployee(Person employee) throws ValidationException;

    /**
     * Display the employees which were added to the created list
     * @return return the list with the Employees.
     */
    List<Person> listEmployee();
}
