package repository.Impl;

import entity.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import repository.EmployeeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Log
@Slf4j
@AllArgsConstructor
public class EmployeeRepoImpl implements EmployeeRepo {

    @Override
    public void addEmployee(Employee employee) {
        Connection connection = DBConnection.connect();
        //language=SQL
        String sql = "insert into employees (first_name, last_name) values (?,?) ";
        int row;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            row = preparedStatement.executeUpdate();
            System.out.println("Row added " + row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        //SQL
        String SQL = "select * from employees";
        try (Connection connection = DBConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            while (resultSet.next()) {
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
    public void deleteEmployeeById(int id) {
        Connection connection = DBConnection.connect();
        //SQL
        String sql = "delete from employees where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        String SQL = "UPDATE book SET title = ?, author = ?, price = ?";
        SQL += " WHERE book_id = ?";
        try (Connection connection = DBConnection.connect(); PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            boolean rowUpdated = statement.executeUpdate() > 0;
            statement.close();
            return rowUpdated;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
