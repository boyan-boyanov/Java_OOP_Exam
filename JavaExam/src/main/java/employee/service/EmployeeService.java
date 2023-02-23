package employee.service;

import department.data.Department;
import department.service.DepartmentService;
import employee.data.Employee;

public interface EmployeeService {

    void hire(String[] employee);

    void promote(Employee employee, Double percentage, DepartmentService departmentService, EmployeeServiceImpl employeeServiceImpl);

    String presentEmployeeData(Employee employee, DepartmentService departmentService);

    Employee getEmployeeById(String employeeId);

    void moveToDepartment(Employee employee, Department department, Double spendBudgetOnNewDepartment);

    void moveToDepartment(Employee employee, Department department, Department currentDepartment, Double spendBudgetOnNewDepartment);
}
