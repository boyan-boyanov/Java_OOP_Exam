package department.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import department.data.Department;
import department.persistence.DepartmentPersistence;
import department.service.calculateBudget.CalculateBudget;
import department.viewer.DepartmentView;
import employee.service.EmployeeServiceImpl;

public class DepartmentServiceTest {

    private DepartmentPersistence departmentPersistenceMock;
    private CalculateBudget calculateBudgetMock;
    private DepartmentView departmentViewMock;
    private DepartmentService departmentService;

    @Before
    public void setUp() {
        departmentPersistenceMock = mock(DepartmentPersistence.class);
        calculateBudgetMock = mock(CalculateBudget.class);
        departmentViewMock = mock(DepartmentView.class);
        departmentService = new DepartmentService(departmentPersistenceMock, calculateBudgetMock, departmentViewMock);
    }

    @Test
    public void testCreateDepartment() {
        String[] departmentInfo = {"popo1", "Test Department", "1000.0"};
        departmentService.createDepartment(departmentInfo);
        verify(departmentPersistenceMock).createDepartment(departmentInfo);
    }

    @Test
    public void testGetDepartmentById() {
        Department expectedDepartment = new Department("popo1", "Test Department", 1000.0);
        when(departmentPersistenceMock.getDepartmentById("popo1")).thenReturn(expectedDepartment);

        Department actualDepartment = departmentService.getDepartmentById("popo1");

        assertEquals(expectedDepartment, actualDepartment);
        verify(departmentPersistenceMock).getDepartmentById("popo1");
    }

    @Test
    public void testCalculateSpendBudget() {
        EmployeeServiceImpl employeeServiceImplMock = mock(EmployeeServiceImpl.class);
        Department departmentMock = mock(Department.class);
        Double expectedBudget = 500.0;
        when(calculateBudgetMock.calculateSpendBudget(employeeServiceImplMock, departmentMock)).thenReturn(expectedBudget);

        Double actualBudget = departmentService.calculateSpendBudget(employeeServiceImplMock, departmentMock);
        assertEquals(expectedBudget, actualBudget);
        verify(calculateBudgetMock).calculateSpendBudget(employeeServiceImplMock, departmentMock);
    }

    @Test
    public void testViewDepartment() {
        Department departmentMock = mock(Department.class);
        EmployeeServiceImpl employeeServiceImplMock = mock(EmployeeServiceImpl.class);
        String expectedView = "Department View";
        when(departmentViewMock.viewDepartment(departmentMock, departmentService, employeeServiceImplMock)).thenReturn(expectedView);

        String actualView = departmentService.viewDepartment(departmentMock, departmentService, employeeServiceImplMock);

        assertEquals(expectedView, actualView);

        verify(departmentViewMock).viewDepartment(departmentMock, departmentService, employeeServiceImplMock);
    }
}