package controller;


import entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.Impl.EmployeeRepoImpl;

import java.io.IOException;


@WebServlet(value = "/employee", name = "EmployeeController")
public class EmployeeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("doPost");
        String requestFirstName = req.getParameter("firstname");
        String requestNameLastName = req.getParameter("lastname");
        // EmployeeCreationDTO employeeCreationDTO = new EmployeeCreationDTO(requestFirstName,requestNameLastName);
        // employeeCreationDTO
        Employee employee = new Employee(requestFirstName, requestNameLastName);
        EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
        employeeRepo.addEmployee(employee);
        System.out.println(requestFirstName + " " + requestNameLastName);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
        employeeRepo.getAllEmployee();
        System.out.println(employeeRepo.getAllEmployee());

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doDelete");
        int id = Integer.parseInt(req.getParameter("id"));
        EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
        employeeRepo.deleteEmployeeById(id);
    }
}
