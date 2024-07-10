package controller.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import service.Impl.EmployeeServiceImpl;

@Log
@WebServlet(value = "/employee/", name = "GetEmployee")
public class GetEmployee extends HttpServlet {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        log.info("GetEmployee doGet");
        int id = Integer.parseInt(req.getParameter("id"));
        log.info("id = " + id);
        employeeService.getEmployeeById(id);
    }
}

