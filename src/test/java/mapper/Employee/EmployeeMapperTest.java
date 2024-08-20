package mapper.Employee;

import dto.Employee.EmployeeCreationDTO;
import entity.Employee;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class EmployeeMapperTest {
    EmployeeMapper mapper = new EmployeeMapper();

    @Test
    void dtoToEntity() {
        EmployeeCreationDTO dto = new EmployeeCreationDTO();
        // Create an instance of the EmployeeMapper class


        // Call the dtoToEntity method
        dto.setFirst_name("John");
        dto.setLast_name("Doe");
        Employee employee = mapper.dtoToEntity(dto);

        // Assert that the employee object is not null
        assertNotNull(employee);

        // Assert that the first_name and last_name properties are set correctly
        assertEquals("John", employee.getFirst_name());
        assertEquals("Doe", employee.getLast_name());
    }


    @Test
    void entityToDto() {
        Employee employee = new Employee();
        employee.setFirst_name("John");
        employee.setLast_name("Doe");
        mapper.entityToDto(employee);
        assertEquals("John", employee.getFirst_name());
        assertEquals("Doe", employee.getLast_name());
    }
}