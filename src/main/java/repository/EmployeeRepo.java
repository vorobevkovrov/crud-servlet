package repository;

import entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepo {
    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);

    void updateEmployee(EmployeeRepo employee);

    void deleteEmployeeById(int id);
}
