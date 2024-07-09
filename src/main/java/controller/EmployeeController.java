package controller;


import dto.Employee.EmployeeCreationDTO;
import entity.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import repository.Impl.EmployeeRepoImpl;
import service.EmployeeService;


@Log
@WebServlet(value = "/employee", name = "EmployeeController")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeService();
    private final EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String requestFirstName = req.getParameter("firstname");
        String requestLastName = req.getParameter("lastname");
        log.info("doPost controller " + requestFirstName + " " + requestLastName);
        EmployeeCreationDTO employeeCreationDTO = new EmployeeCreationDTO(requestFirstName, requestLastName);
        employeeService.saveEmployee(employeeCreationDTO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        log.info("doGet");
        employeeRepo.getAllEmployee();
        log.info(String.valueOf(employeeRepo.getAllEmployee()));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        log.info("doDelete");
        int id = Integer.parseInt(req.getParameter("id"));
        employeeRepo.deleteEmployeeById(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        log.info("doPut");
        int id = Integer.parseInt(req.getParameter("id"));
        String requestFirstName = req.getParameter("firstname");
        String requestLastName = req.getParameter("lastname");
        log.info(id + " " + requestFirstName + " " + requestLastName);
        employeeRepo.updateEmployee(Employee.builder().id(id)
                .first_name(requestFirstName)
                .last_name(requestLastName)
                .build());
    }
}
