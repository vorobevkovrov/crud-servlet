package repository;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepo {
    List<Employee> getAllEmployee();

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee) throws SQLException;

    boolean deleteEmployeeById(int id);

    Employee findById(int id);
}
