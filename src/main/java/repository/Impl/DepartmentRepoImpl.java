package repository.Impl;

import entity.Department;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import repository.DepartmentRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Log
@AllArgsConstructor
public class DepartmentRepoImpl implements DepartmentRepo {

    @Override
    public boolean addDepartment(Department department) {
        //language=SQL
        final String SQL = "insert into departments (department_name) values (?) ";
        int row;
        log.info("DepartmentRepoImpl addDepartment " + department.getDepartmentName());
        try (Connection connection = DBConnection.connect();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, department.getDepartmentName());
           // row = statement.executeUpdate();
          // log.info("Row added " + row);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Department getById(int id) {
        return null;
    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void delete(int id) {

    }
}
