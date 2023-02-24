package department.service;

import department.data.Department;
import department.persistence.DepartmentPersistence;
import department.service.calculateBudget.CalculateBudget;
import department.service.updateDepartment.UpdateDepartmentService;
import department.viewer.DepartmentView;
import employee.service.EmployeeServiceImpl;

public class DepartmentService implements DepartmentServiceInterface {

    private final DepartmentPersistence departmentPersistence;

    private final CalculateBudget calculateBudget;

    private final DepartmentView departmentView;
    private final UpdateDepartmentService updateDepartmentService;

    public DepartmentService(DepartmentPersistence departmentPersistence, CalculateBudget calculateBudget, DepartmentView departmentView, UpdateDepartmentService updateDepartmentService) {
        this.departmentPersistence = departmentPersistence;
        this.calculateBudget = calculateBudget;
        this.departmentView = departmentView;
        this.updateDepartmentService = updateDepartmentService;
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

    @Override
    public void updateDepartment(String departmentId, String newDepartmentName, Double newDepartmentBudget, Department currentDepartment, EmployeeServiceImpl employeeServiceImpl) {
        updateDepartmentService.updateDepartment(departmentId, newDepartmentName, newDepartmentBudget, currentDepartment, employeeServiceImpl);
    }
}
