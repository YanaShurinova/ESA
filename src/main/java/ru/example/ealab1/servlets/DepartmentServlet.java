package ru.example.ealab1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.example.ealab1.services.DepartmentService;
import ru.example.ealab1.models.dto.DepartmentRequest;
import ru.example.ealab1.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "departmentServlet", value = "/departments")
public class DepartmentServlet extends HttpServlet {

    private ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private DepartmentService departmentService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(departmentService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (InputStream is = req.getInputStream()) {
            DepartmentRequest departmentRequest = objectMapper.readValue(is, DepartmentRequest.class);
            departmentService.create(departmentRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        UUID departmentId = UUID.fromString(req.getPathInfo().substring(1));
        departmentService.delete(departmentId);
    }
}
