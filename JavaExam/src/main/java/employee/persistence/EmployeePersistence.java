package employee.persistence;

import employee.data.Employee;

import java.util.HashMap;

public interface EmployeePersistence {
    void hireEmployee(String[] employeeInfo);
    HashMap<String, Employee> getHiredEmployees();
    Employee getEmployeeById(String employeeId);
    void changeEmployeeDepartment(String employeeId, String departmentId);
}
