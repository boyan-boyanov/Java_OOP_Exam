package employee.viewer;
import department.service.DepartmentService;
import employee.data.Employee;

public interface EmployeeViewer {
    String viewEmployee(Employee employee, DepartmentService departmentService);
}
