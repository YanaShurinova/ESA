package ru.example.ealab1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ru.example.ealab1.models.DepartmentEntity;
import ru.example.ealab1.models.EmployeeEntity;
import ru.example.ealab1.services.DepartmentService;
import ru.example.ealab1.services.EmployeeService;
import ru.example.ealab1.utils.ObjectToDomTransformer;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    @GetMapping(value = "/departments_xml")
    public String getDepartments(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("departments");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<DepartmentEntity> departments = departmentService.getAll();
        for (DepartmentEntity department : departments) {

            transformer.transform(element, department, "department");
        }

        model.addAttribute("departments", element);
        return "departments";
    }

    @GetMapping(value = "/employees_xml")
    public String getEmployees(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("employees");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<EmployeeEntity> employees = employeeService.getAll();
        for (EmployeeEntity employee : employees) {

            transformer.transform(element, employee, "employee");
        }

        model.addAttribute("employees", element);
        return "employees";
    }
}
