package department.persistence;

import department.data.Department;
import employee.data.Employee;

import java.util.HashMap;

public interface DepartmentPersistence {

    void createDepartment(String[] departmentInfo);

    Department getDepartmentById(String departmentId);

    HashMap<String, Department> getAllDepartments();


}
