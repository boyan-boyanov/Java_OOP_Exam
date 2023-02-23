package department.service;

import department.data.Department;
import department.persistence.DepartmentPersistence;
import department.service.calculateBudget.CalculateBudget;
import department.viewer.DepartmentView;
import employee.service.EmployeeServiceImpl;

public class DepartmentService implements DepartmentServiceInterface {

    private final DepartmentPersistence departmentPersistence;

    private final CalculateBudget calculateBudget;

    private final DepartmentView departmentView;

    public DepartmentService(DepartmentPersistence departmentPersistence, CalculateBudget calculateBudget, DepartmentView departmentView) {
        this.departmentPersistence = departmentPersistence;
        this.calculateBudget = calculateBudget;
        this.departmentView = departmentView;
    }

    @Override
    public void createDepartment(String[] department) {
        departmentPersistence.createDepartment(department);
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        return departmentPersistence.getDepartmentById(departmentId);
    }


    @Override
    public Double calculateSpendBudget(EmployeeServiceImpl employeeServiceImpl, Department department) {

        return calculateBudget.calculateSpendBudget(employeeServiceImpl, department);
    }

    @Override
    public String viewDepartment(Department departmentToShow, DepartmentService departmentService, EmployeeServiceImpl employeeServiceImpl) {
      return  departmentView.viewDepartment(departmentToShow, departmentService, employeeServiceImpl);
    }
}
