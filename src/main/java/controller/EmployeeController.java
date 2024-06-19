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
        // EmployeeCreationDTO employeeCreationDTO = new EmployeeCreationDTO(requestFirstName,requestNameLastName);
        // employeeCreationDTO
        Employee employee = new Employee(requestFirstName, requestNameLastName);
        //  EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
        employeeRepo.addEmployee(employee);
        System.out.println(requestFirstName + " " + requestNameLastName);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doGet");
        //   EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
        employeeRepo.getAllEmployee();
        System.out.println(employeeRepo.getAllEmployee());

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doDelete");
        int id = Integer.parseInt(req.getParameter("id"));
        EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
        employeeRepo.deleteEmployeeById(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doPut");
//        int id = Integer.parseInt(req.getParameter("id"));
//        EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
//        employeeRepo.updateEmployee();
    }
}
