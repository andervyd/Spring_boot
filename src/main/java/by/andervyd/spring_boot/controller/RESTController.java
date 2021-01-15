package by.andervyd.spring_boot.controller;

import by.andervyd.spring_boot.entity.Employee;
import by.andervyd.spring_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {

        List<Employee> allEmployee = employeeService.getAllEmployees();

        return allEmployee;
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {

        Employee employee = employeeService.getEmployee(id);

        return  employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {

        employeeService.savingEmployeeData(employee);

        return  employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.savingEmployeeData(employee);

        return  employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return  "Employee with ID: " + id + " was delete.";
    }
}
