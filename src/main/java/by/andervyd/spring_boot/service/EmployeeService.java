package by.andervyd.spring_boot.service;

import by.andervyd.spring_boot.entity.Employee;
import java.util.List;


public interface EmployeeService {

    public List<Employee> getAllEmployees();

/*
    public void savingEmployeeData(Employee employee);

    public Employee getEmployee(Long id);

    public void deleteEmployee(Long id);
*/
}
