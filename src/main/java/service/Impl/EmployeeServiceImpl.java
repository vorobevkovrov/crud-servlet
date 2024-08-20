package service.Impl;

import com.google.gson.Gson;
import dto.Employee.EmployeeCreationDTO;
import entity.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import mapper.Employee.EmployeeMapper;
import repository.Impl.EmployeeRepoImpl;
import service.EmployeeService;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Log
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeMapper employeeMapper = new EmployeeMapper();
    private EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();

    public void saveEmployee(EmployeeCreationDTO employeeCreationDTO) {
        Employee employee = employeeMapper.dtoToEntity(employeeCreationDTO);
        employeeRepo.addEmployee(employee);
    }

    public List<Employee> receiveAllEmployee() {
        return null;
    }

    @Override
    public String getEmployeeById(int id) {
        log.info("getEmployeeById employeeServiceImpl");
        return new Gson().toJson(employeeMapper.entityToDto(employeeRepo.findById(id)));
    }
}
