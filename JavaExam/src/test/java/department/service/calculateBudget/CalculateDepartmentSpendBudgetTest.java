package department.service.calculateBudget;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import department.data.Department;
import department.persistence.DepartmentPersistence;
import department.service.DepartmentService;
import department.service.calculateBudget.CalculateBudget;
import department.service.calculateBudget.CalculateDepartmentSpendBudget;
import department.viewer.DepartmentView;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class CalculateDepartmentSpendBudgetTest {

    private CalculateDepartmentSpendBudget calculateBudget;
    private EmployeeServiceImpl employeeService;
    private CalculateDepartmentSpendBudget budgetCalculator;
    private Department department;
    private HashSet<String> employees;

    @Before
    public void setUp() {
        calculateBudget = new CalculateDepartmentSpendBudget();
        employeeService = mock(EmployeeServiceImpl.class);


        budgetCalculator = new CalculateDepartmentSpendBudget();
        department = new Department("Department A", "test department", 1000000.00);
        employees = new HashSet<String>();
        employees.add("001");
        employees.add("002");
    }

    @Test
    public void testCalculateSpendBudget() {

        EmployeeServiceImpl employeeService = Mockito.mock(EmployeeServiceImpl.class);
        Department department = Mockito.mock(Department.class);
        HashSet<String> employeeIds = new HashSet<String>(Arrays.asList("qwerty1", "we23sd", "es34"));
        Mockito.when(department.getAssignedEmployee()).thenReturn(employeeIds);
        Mockito.when(employeeService.getEmployeeById("qwerty1")).thenReturn(new Employee("qwerty1", "Petar", "Petrov", 50000.00));
        Mockito.when(employeeService.getEmployeeById("we23sd")).thenReturn(new Employee("we23sd", "Jojo", "tt", 60000.00));
        Mockito.when(employeeService.getEmployeeById("es34")).thenReturn(new Employee("es34", "Bobo", "Men", 70000.00));

        CalculateDepartmentSpendBudget budgetCalculator = new CalculateDepartmentSpendBudget();

        Double result = budgetCalculator.calculateSpendBudget(employeeService, department);

        assertEquals(180000.00, result, 0.001);
        Mockito.verify(department, Mockito.times(1)).getAssignedEmployee();
        Mockito.verify(employeeService, Mockito.times(1)).getEmployeeById("qwerty1");
        Mockito.verify(employeeService, Mockito.times(1)).getEmployeeById("we23sd");
        Mockito.verify(employeeService, Mockito.times(1)).getEmployeeById("es34");
    }


}