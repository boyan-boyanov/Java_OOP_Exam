package department.persistence;

import department.data.Department;
import employee.data.Employee;

import java.util.HashMap;

public class DepartmentPersistenceInMemory implements DepartmentPersistence{

    private static final HashMap<String, Department> createdDepartments = new HashMap<>();


    @Override
    public void createDepartment(String[] departmentInfo) {
        String departmentId = departmentInfo[1];

        if (createdDepartments.containsKey(departmentId)) {
            throw new IllegalArgumentException("Department with " + departmentId + " already exists");
        } else {
            String departmentName = departmentInfo[2];
            Double yearlyBudget = Double.parseDouble(departmentInfo[3]);
            Department department = new Department(departmentId, departmentName, yearlyBudget);
            createdDepartments.put(departmentId, department);
        }
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        if (createdDepartments.containsKey(departmentId)) {
            return createdDepartments.get(departmentId);
        } else {
            throw new IllegalArgumentException("Department with ID " + departmentId + " does not exist!");
        }
    }

    @Override
    public HashMap<String, Department> getAllDepartments() {
        return createdDepartments;
    }
}
