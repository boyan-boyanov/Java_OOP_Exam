package department.service.calculateBudget;

import department.data.Department;
import employee.service.EmployeeServiceImpl;

public interface CalculateBudget {
    Double calculateSpendBudget(EmployeeServiceImpl employeeServiceImpl, Department department);
}
