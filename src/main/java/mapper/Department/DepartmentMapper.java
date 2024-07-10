package mapper.Department;

import dto.DepartmentDTO.DepartmentCreationDTO;
import entity.Department;


public class DepartmentMapper {
    public Department dtoToDepartment(DepartmentCreationDTO creationDTO) {
        Department department = new Department();
        department.setDepartmentName(creationDTO.getDepartmentName());
        return department;
    }
}
