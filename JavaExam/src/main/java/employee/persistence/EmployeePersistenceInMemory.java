package employee.persistence;

import employee.data.Employee;

import java.util.HashMap;

public class EmployeePersistenceInMemory implements EmployeePersistence {
    private static final HashMap<String, Employee> hiredEmployees = new HashMap<>();

    public  void hireEmployee(String[] employeeInfo) {
        String employeeId = employeeInfo[1];

        if (hiredEmployees.containsKey(employeeId)) {
            throw new IllegalArgumentException("Employee with " + employeeId + " already exists");
        } else {
            String firstName = employeeInfo[2];
            String lastName = employeeInfo[3];
            Double salary = Double.parseDouble(employeeInfo[4]);
            Employee employee = new Employee(employeeId, firstName, lastName, salary);
            hiredEmployees.put(employeeId, employee);
        }
    }

    public  HashMap<String, Employee> getHiredEmployees() {
        return
                hiredEmployees;
    }

    public  Employee getEmployeeById(String employeeId) {
        if (hiredEmployees.containsKey(employeeId)) {
            return hiredEmployees.get(employeeId);
        } else {
            throw new IllegalArgumentException("Employee with ID " + employeeId + " does not exist!");
        }
    }

    public  void changeEmployeeDepartment(String employeeId, String departmentId){
        Employee currentEmployee = hiredEmployees.get(employeeId);
        currentEmployee.setWorkInDepartment(departmentId);
    }
}
