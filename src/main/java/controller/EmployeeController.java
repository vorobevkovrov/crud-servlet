package controller;


import entity.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.Impl.EmployeeRepoImpl;


@WebServlet(value = "/employee", name = "EmployeeController")
public class EmployeeController extends HttpServlet {
    private final EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String requestFirstName = req.getParameter("firstname");
        String requestLastName = req.getParameter("lastname");
        System.out.println("doPost controller " + requestFirstName + " " + requestLastName);
        employeeRepo.addEmployee(Employee.builder().first_name(requestFirstName)
                .last_name(requestLastName)
                .build());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doGet");
        employeeRepo.getAllEmployee();
        System.out.println(employeeRepo.getAllEmployee());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doDelete");
        int id = Integer.parseInt(req.getParameter("id"));
        employeeRepo.deleteEmployeeById(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doPut");
        int id = Integer.parseInt(req.getParameter("id"));
        String requestFirstName = req.getParameter("firstname");
        String requestLastName = req.getParameter("lastname");
        System.out.println(id + " " + requestFirstName + " " + requestLastName);
        employeeRepo.updateEmployee(Employee.builder().id(id)
                .first_name(requestFirstName)
                .last_name(requestLastName)
                .build());
    }
}
