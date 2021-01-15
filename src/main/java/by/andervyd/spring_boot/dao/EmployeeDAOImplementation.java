package by.andervyd.spring_boot.dao;

import by.andervyd.spring_boot.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = entityManager.unwrap(Session.class);

        List<Employee> allEmployee = session.createQuery(
                "FROM Employee", Employee.class).getResultList();

        return allEmployee;
    }

/*
    @Override
    public void savingEmployeeData(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);

    }

    @Override
    public Employee getEmployee(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery(
                "DELETE FROM Employee WHERE id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
*/
}
