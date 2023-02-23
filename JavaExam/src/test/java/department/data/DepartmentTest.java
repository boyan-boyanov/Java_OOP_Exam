package department.data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;

import static org.junit.Assert.*;

public class DepartmentTest {

    private Department department;

    @Before
    public void setUp() {
        department = new Department("Frodo1", "Sales", 100000.0);
        DepartmentInterface mockedDepartment = Mockito.mock(DepartmentInterface.class);
    }

    @Test
    public void testGetDepartmentID() {

        assertEquals("Frodo1", department.getDepartmentID());
    }

    @Test
    public void testGetDepartmentName() {

        assertEquals("Sales", department.getDepartmentName());
    }

    @Test
    public void testGetYearlyBudget() {

        assertEquals(100000.0, department.getYearlyBudget(), 0.001);
    }

    @Test
    public void testAddEmployeeToList() {
        department.addEmployeeToList("Gad66");
        HashSet<String> assignedEmployees = department.getAssignedEmployee();
        assertEquals(1, assignedEmployees.size());
        assertTrue(assignedEmployees.contains("Gad66"));
    }

    @Test
    public void testRemoveEmployeeFromList() {
        department.addEmployeeToList("Gad66");
        department.addEmployeeToList("Brumbar");
        department.removeEmployeeFromList("Gad66");
        HashSet<String> assignedEmployees = department.getAssignedEmployee();
        assertEquals(1, assignedEmployees.size());
        assertFalse(assignedEmployees.contains("Gad66"));
        assertTrue(assignedEmployees.contains("Brumbar"));
    }

    @Test
    public void testGetAssignedEmployee() {
        department.addEmployeeToList("Gad66");
        department.addEmployeeToList("Brumbar");
        HashSet<String> assignedEmployees = department.getAssignedEmployee();
        assertEquals(2, assignedEmployees.size());
        assertTrue(assignedEmployees.contains("Gad66"));
        assertTrue(assignedEmployees.contains("Brumbar"));
    }

}