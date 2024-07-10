package service.Impl;

import dto.DepartmentDTO.DepartmentCreationDTO;
import entity.Department;
import entity.Employee;
import mapper.Department.DepartmentMapper;
import repository.Impl.DepartmentRepoImpl;

import java.util.List;


public class DepartmentService {
    DepartmentMapper departmentMapper = new DepartmentMapper();

    public void saveDepartment(DepartmentCreationDTO departmentCreationDTOO) {
        Department department = departmentMapper.dtoToDepartment(departmentCreationDTOO);
        DepartmentRepoImpl departmentRepo = new DepartmentRepoImpl();
        departmentRepo.addDepartment(department);
    }

}
