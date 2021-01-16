package by.andervyd.spring_boot.dao;

import by.andervyd.spring_boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        Query query = entityManager.createQuery("FROM Employee");
        List<Employee> allEmployee = query.getResultList();

        return allEmployee;
    }

    @Override
    public Employee getEmployee(Long id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void savingEmployeeData(Employee employee) {

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public void deleteEmployee(Long id) {

        Query query = entityManager.createQuery(
                "DELETE FROM Employee WHERE id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
