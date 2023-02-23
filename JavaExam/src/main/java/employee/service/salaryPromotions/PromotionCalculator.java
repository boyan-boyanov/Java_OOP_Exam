package employee.service.salaryPromotions;

import department.service.DepartmentService;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;

public interface PromotionCalculator {
    void increaseSalary(Employee employee, Double percentage, DepartmentService departmentService, EmployeeServiceImpl employeeServiceImpl);
}
