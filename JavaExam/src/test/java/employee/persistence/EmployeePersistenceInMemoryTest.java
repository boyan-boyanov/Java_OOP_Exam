package employee.persistence;

import department.data.Department;
import employee.data.Employee;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

public class EmployeePersistenceInMemoryTest {
    @Mock
    private HashMap<String, Employee> hiredEmployeesMock;
    private EmployeePersistenceInMemory persistence;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        persistence = new EmployeePersistenceInMemory();

    }

    @Test
    public void testHireEmployee() {
        String[] employeeInfo = {"", "123", "John", "Doe", "1000.0"};
        Employee employee = new Employee("123", "John", "Doe", 1000.0);

        persistence.hireEmployee(employeeInfo);
        assertEquals(employee.getSalary(), persistence.getEmployeeById("123").getSalary());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNonExistingEmployeeById() throws IllegalArgumentException {
        String employeeId = "123456";
        persistence.getEmployeeById(employeeId);
    }

}