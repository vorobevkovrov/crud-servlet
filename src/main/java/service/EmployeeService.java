package service;

import dto.Employee.EmployeeCreationDTO;
import entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeCreationDTO employeeCreationDTO);

    List<Employee> receiveAllEmployee();

    Employee getEmployeeById(int id);
}
