package employee.viewer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import department.data.Department;
import department.service.DepartmentService;
import employee.data.Employee;
import org.mockito.MockitoAnnotations;

public class ConsoleEmployeeViewerTest {
    @Mock
    DepartmentService departmentServiceMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testViewEmployeeWithDepartment() {
        Employee employee = new Employee("001", "John", "Doe", 50000.0);
        Department department = new Department("001", "Sales", 1000000.0);

        when(departmentServiceMock.getDepartmentById("001")).thenReturn(department);
        ConsoleEmployeeViewer viewer = new ConsoleEmployeeViewer();

        String result = viewer.viewEmployee(employee, departmentServiceMock);

        assertEquals("Employee ID: 001, name: John Doe, Department: N/A, Salary: 50000.00", result);
    }

}