package controller.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import service.Impl.EmployeeServiceImpl;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;

@Log
@WebServlet(value = "/employee/", name = "GetEmployee")
public class GetEmployee extends HttpServlet {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        log.info("GetEmployee doGet");
        int id = Integer.parseInt(req.getParameter("id"));
        log.info("id = " + id);
        PrintWriter out = resp.getWriter();
        out.print(employeeService.getEmployeeById(id));
        employeeService.getEmployeeById(id);
    }
}

