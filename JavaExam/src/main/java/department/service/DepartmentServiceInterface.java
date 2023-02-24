package department.service;

import department.data.Department;
import employee.service.EmployeeServiceImpl;

public interface DepartmentServiceInterface {
    void createDepartment(String[] department);
    Department getDepartmentById(String departmentId);


    Double calculateSpendBudget(EmployeeServiceImpl employeeServiceImpl, Department department);

    String viewDepartment(Department departmentToShow, DepartmentService departmentService, EmployeeServiceImpl employeeServiceImpl);

    void updateDepartment(String departmentId, String newDepartmentName, Double newDepartmentBudget,
                          Department currentDepartment, EmployeeServiceImpl employeeServiceImpl);
}
