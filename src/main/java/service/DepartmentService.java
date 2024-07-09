package service;

import dto.DepartmentDTO.DepartmentCreationDTO;
import entity.Department;
import mapper.Department.DepartmentMapper;
import repository.Impl.DepartmentRepoImpl;


public class DepartmentService {
    DepartmentMapper departmentMapper = new DepartmentMapper();

    public void saveDepartment(DepartmentCreationDTO departmentCreationDTOO) {
        Department department = departmentMapper.dtoToDepartment(departmentCreationDTOO);
        DepartmentRepoImpl departmentRepo = new DepartmentRepoImpl();
        departmentRepo.addDepartment(department);
    }
}
