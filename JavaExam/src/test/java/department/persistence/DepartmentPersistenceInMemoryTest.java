package department.persistence;

import static org.junit.Assert.*;

import department.data.Department;
import org.junit.Before;
import org.junit.Test;import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class DepartmentPersistenceInMemoryTest {

    private DepartmentPersistenceInMemory departmentPersistenceInMemory;
    @Before
    public void setUp() {
        departmentPersistenceInMemory = new DepartmentPersistenceInMemory();
    }



    @Test(expected = IllegalArgumentException.class)
    public void testGetNonexistentDepartmentById() {
        departmentPersistenceInMemory.getDepartmentById("d001");
    }


}