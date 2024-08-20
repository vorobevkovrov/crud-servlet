package mapper.Employee;

import dto.Employee.EmployeeCreationDTO;
import dto.Employee.EmployeeDTO;
import entity.Employee;

public class EmployeeMapper {

    public Employee dtoToEntity(EmployeeCreationDTO employeeCreationDTO) {
        Employee employee = new Employee();
        employee.setFirst_name(employeeCreationDTO.getFirst_name());
        employee.setLast_name(employeeCreationDTO.getLast_name());
        return employee;
    }

    public EmployeeDTO entityToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirst_name(employee.getFirst_name());
        employeeDTO.setLast_name(employee.getLast_name());
        return employeeDTO;
    }
}
