package repository.Impl;

import entity.Department;
import lombok.AllArgsConstructor;
import repository.DepartmentRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@AllArgsConstructor
public class DepartmentRepoImpl implements DepartmentRepo {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    @Override
    public Department getById(int id) {
        return null;
    }

    @Override
    public void add(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void delete(Department department) {

    }
}
