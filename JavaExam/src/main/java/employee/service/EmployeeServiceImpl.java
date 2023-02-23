package employee.service;

import department.data.Department;
import department.service.DepartmentService;
import employee.data.Employee;
import employee.persistence.EmployeePersistence;
import employee.service.assignDepartment.EmployeeAssignDepartment;
import employee.service.salaryPromotions.PromotionCalculator;
import employee.viewer.EmployeeViewer;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeePersistence employeePersistence;

    private final EmployeeViewer employeeViewer;

    private final PromotionCalculator promotionCalculator;

    private final EmployeeAssignDepartment employeeAssignDepartment;

    public EmployeeServiceImpl(EmployeePersistence employeePersistence, EmployeeViewer employeeViewer, PromotionCalculator promotionCalculator, EmployeeAssignDepartment employeeAssignDepartment) {
        this.employeePersistence = employeePersistence;
        this.employeeViewer = employeeViewer;
        this.promotionCalculator = promotionCalculator;
        this.employeeAssignDepartment = employeeAssignDepartment;
    }

    @Override
    public void hire(String[] employee) {

        employeePersistence.hireEmployee(employee);
    }

    @Override
    public void promote(Employee employee, Double percentage, DepartmentService departmentService, EmployeeServiceImpl employeeServiceImpl) {
        promotionCalculator.increaseSalary(employee, percentage, departmentService, employeeServiceImpl);
    }

    @Override
    public String presentEmployeeData(Employee employee, DepartmentService departmentService) {

        return employeeViewer.viewEmployee(employee, departmentService);
    }

    @Override
    public Employee getEmployeeById(String employeeId) {

        return employeePersistence.getEmployeeById(employeeId);
    }

    @Override
    public void moveToDepartment(Employee employee, Department department, Double spendBudgetOnNewDepartment) {
        employeeAssignDepartment.moveToDepartment(employee, department, spendBudgetOnNewDepartment);
    }

    @Override
    public void moveToDepartment(Employee employee, Department department, Department currentDepartment, Double spendBudgetOnNewDepartment) {
        employeeAssignDepartment.moveToDepartment(employee, department, currentDepartment, spendBudgetOnNewDepartment);
    }
}
