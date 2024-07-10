package service.Impl;

import dto.Employee.EmployeeCreationDTO;
import entity.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mapper.Employee.EmployeeMapper;
import repository.Impl.EmployeeRepoImpl;
import service.EmployeeService;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeMapper employeeMapper = new EmployeeMapper();

    public void saveEmployee(EmployeeCreationDTO employeeCreationDTO) {
        Employee employee = employeeMapper.dtoToEmployee(employeeCreationDTO);
        EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
        employeeRepo.addEmployee(employee);
    }
    public List<Employee> receiveAllEmployee(){
        return null;
    }

    @Override
    public Employee getEmployeeById() {

        return null;
    }
}
