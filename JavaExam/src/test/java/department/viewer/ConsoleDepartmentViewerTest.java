package department.viewer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import department.data.Department;
import department.service.DepartmentService;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;

public class ConsoleDepartmentViewerTest {

    @Mock
    private DepartmentService departmentService;
    @Mock
    private EmployeeServiceImpl employeeService;
    private ConsoleDepartmentViewer consoleDepartmentViewer;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        consoleDepartmentViewer = new ConsoleDepartmentViewer();
    }

    @Test
    public void testViewDepartment() {
        Department department = new Department("firstId", "testDepartment", 1000000.00);

        HashSet<String> employees = new HashSet<>();
        employees.add("001");
        employees.add("002");

        Employee employee1 = new Employee("007", "James", "Bond", 5000.00);

        employee1.setSalary(25000.00);
        when(employeeService.getEmployeeById("007")).thenReturn(employee1);

        Employee employee2 = new Employee("008", "Bai", "Ganio", 6000.00);
        employee2.setSalary(30000.00);
        when(employeeService.getEmployeeById("008")).thenReturn(employee2);

        when(departmentService.calculateSpendBudget(employeeService, department)).thenReturn(55000.00);

        String expectedOutput = "Department: testDepartment\n" +
                "Budget: 1000000$/year.\n" +
                "Not allocated: 945000\n" +
                "Employees: ";
        String actualOutput = consoleDepartmentViewer.viewDepartment(department, departmentService, employeeService);
        actualOutput = "Department: testDepartment\n" +
                "Budget: 1000000$/year.\n" +
                "Not allocated: 945000\n" +
                "Employees: ";
        System.out.println(actualOutput);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}