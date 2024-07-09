package repository;

import entity.Department;

public interface DepartmentRepo {
    Department getById(int id);

    boolean addDepartment(Department department);

    void update(Department department);

    void delete(int id);
}
