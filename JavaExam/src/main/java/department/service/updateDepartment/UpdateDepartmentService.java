package department.service.updateDepartment;

import department.data.Department;
import employee.service.EmployeeServiceImpl;

public interface UpdateDepartmentService {
    void updateDepartment(String departmentId, String newDepartmentName, Double newDepartmentBudget,
                          Department currentDepartment, EmployeeServiceImpl employeeServiceImpl);
}
