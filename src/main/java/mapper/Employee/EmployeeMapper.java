package mapper.Employee;

import dto.Employee.EmployeeCreationDTO;
import entity.Employee;

public class EmployeeMapper {

    public Employee dtoToEmployee(EmployeeCreationDTO employeeCreationDTO) {
        Employee employee = new Employee();
        employee.setFirst_name(employeeCreationDTO.getFirst_name());
        employee.setLast_name(employeeCreationDTO.getLast_name());
        return employee;
    }
}
