package service.Impl;

import com.google.gson.Gson;
import dto.Employee.EmployeeCreationDTO;
import dto.Employee.EmployeeDTO;
import entity.Employee;
import mapper.Employee.EmployeeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Impl.EmployeeRepoImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {
    @Mock
    EmployeeRepoImpl employeeRepo;
    @Mock
    Employee employee;
    @Mock
    EmployeeCreationDTO employeeCreationDTO;
    @Mock
    EmployeeMapper employeeMapper;
    @Mock
    EmployeeDTO employeeDTO;
    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    private Gson gson = new Gson();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void saveEmployee() {
        // Arrang
        when(employeeMapper.dtoToEntity(employeeCreationDTO)).thenReturn(employee);
        // Act
        employeeService.saveEmployee(employeeCreationDTO);
        // Assert
        verify(employeeMapper, times(1)).dtoToEntity(employeeCreationDTO);
        verify(employeeRepo, times(1)).addEmployee(employee);
    }

    @Test
    void receiveAllEmployee() {
    }

    @Test
    void getEmployeeById() {
        Employee employee1 = new Employee("FirstName","LastName");
        gson.toJson(employee1);
    }
}
