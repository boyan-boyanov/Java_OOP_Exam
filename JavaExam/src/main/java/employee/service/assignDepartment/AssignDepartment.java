package employee.service.assignDepartment;

import department.data.Department;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;

public interface AssignDepartment {
    void moveToDepartment(Employee employee, Department department, Double spendBudgetOnNewDepartment);

    void moveToDepartment(Employee employee, Department department, Department currentDepartment, Double spendBudgetOnNewDepartment);
}
