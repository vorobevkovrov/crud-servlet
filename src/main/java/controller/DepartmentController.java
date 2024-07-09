package controller;


import dto.DepartmentDTO.DepartmentCreationDTO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import repository.Impl.DepartmentRepoImpl;
import service.DepartmentService;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;


@Log
@WebServlet("/department")
public class DepartmentController extends HttpServlet {
    private final DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String requestDepartmentName = req.getParameter("departmentname");
        log.info("doPost controller " + requestDepartmentName);
        DepartmentCreationDTO departmentCreationDTO = new DepartmentCreationDTO(requestDepartmentName);
        departmentService.saveDepartment(departmentCreationDTO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        log.info("doGet");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        log.info("doDelete");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        log.info("doPut");
    }
}

