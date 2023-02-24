package department.service.updateDepartment;

import department.data.Department;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;
import java.util.HashSet;

public class UpdateDepartment implements UpdateDepartmentService {

    public void updateDepartment(String departmentId, String newDepartmentName, Double newDepartmentBudget, Department currentDepartment, EmployeeServiceImpl employeeServiceImpl) {

        Double allSpendBudget = 0.0;

        HashSet<String> assignedEmployee = currentDepartment.getAssignedEmployee();

        for (String employee : assignedEmployee) {
            Employee currentEmployee = employeeServiceImpl.getEmployeeById(employee);
            Double employeeSalary = currentEmployee.getSalary();
            allSpendBudget += employeeSalary;
        }

        if (newDepartmentBudget < allSpendBudget) {
            throw new IllegalArgumentException("We have assigned employees on this department! Minimum new budget for this department is: " + allSpendBudget);
        }

        currentDepartment.setDepartmentName(newDepartmentName);
        currentDepartment.setYearlyBudget(newDepartmentBudget);
    }
}
