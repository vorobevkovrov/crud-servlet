package repository.Impl;

import entity.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import repository.EmployeeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Log
@AllArgsConstructor
public class EmployeeRepoImpl implements EmployeeRepo {
    @Override
    public boolean addEmployee(Employee employee) {
        Connection connection = DBConnection.connect();
        //language=SQL
        String sql = "insert into employees (first_name, last_name) values (?,?) ";
        int row;
        log.info("EmployeeRepoImpl addEmployee " + employee.getFirst_name() + " " + employee.getLast_name());
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
//            row = statement.executeUpdate();
//            log.info("Row added " + row);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        //SQL
        String SQL = "select * from employees";
        try (Connection connection = DBConnection.connect();
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                //TODO переписать все на DTO
                Employee employee = new Employee();
                employee.setFirst_name(resultSet.getString(2));
                employee.setLast_name(resultSet.getString(3));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        //SQL
        String sql = "delete from employees where id=?";
        int row;
        try (Connection connection = DBConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            row = statement.executeUpdate();
            log.info("row deleted " + row);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = new Employee();
        //SQL
        String sql = "select from employees where id=?";
        try (Connection connection = DBConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            //statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setFirst_name(resultSet.getString(1));
                employee.setLast_name(resultSet.getString(2));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }


    @Override
    public boolean updateEmployee(Employee employee) {
        String SQL = "UPDATE employees SET first_name = ?, last_name = ?";
        SQL += " WHERE id = ?";
        log.info(employee.getId() + " " + employee.getFirst_name() + " " + employee.getLast_name());
        try (Connection connection = DBConnection.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setInt(3, employee.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
