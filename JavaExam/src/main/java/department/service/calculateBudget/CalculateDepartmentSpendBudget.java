package department.service.calculateBudget;

import department.data.Department;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;

import java.util.HashSet;

public class CalculateDepartmentSpendBudget implements CalculateBudget {

    public Double calculateSpendBudget(EmployeeServiceImpl employeeServiceImpl, Department department) {
        Double spendBudget = 0.00;
        HashSet<String> allEmployee = department.getAssignedEmployee();
        for (String employee : allEmployee) {
            Employee currentEmployee = employeeServiceImpl.getEmployeeById(employee);
            Double employeeSalary = currentEmployee.getSalary();
            spendBudget += employeeSalary;
        }
        return spendBudget;
    }

}
