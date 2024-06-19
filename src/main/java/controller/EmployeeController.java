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
        System.out.println("doPost");
        String requestFirstName = req.getParameter("firstname");
        String requestNameLastName = req.getParameter("lastname");
        Employee employee = new Employee(requestFirstName, requestNameLastName);
        employeeRepo.addEmployee(employee);
        System.out.println(requestFirstName + " " + requestNameLastName);
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
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
//        int id = Integer.parseInt(req.getParameter("id"));
//        employeeRepo
//        employeeRepo.updateEmployee();
    }
}
