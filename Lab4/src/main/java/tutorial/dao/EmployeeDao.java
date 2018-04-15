package tutorial.dao;


import tutorial.model.Employee;

import java.util.List;

/**
 * Created by roman.kulikov on 6/13/2017.
 * All rights reserved =D
 */
public interface EmployeeDao {

    List<Employee> getEmployees();

    void hireEmployee(Employee p1);
    void fireEmployee(Employee p1);
}
