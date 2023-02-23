package department.viewer;

import department.data.Department;
import department.service.DepartmentService;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;

public interface DepartmentView {
    String viewDepartment(Department departmentToShow, DepartmentService departmentService, EmployeeServiceImpl employeeServiceImpl);
}
