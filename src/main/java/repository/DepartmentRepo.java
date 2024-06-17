package repository;

import entity.Department;

public interface DepartmentRepo {
    Department getById(int id);

    void add(Department department);

    void update(Department department);

    void delete(Department department);
}
