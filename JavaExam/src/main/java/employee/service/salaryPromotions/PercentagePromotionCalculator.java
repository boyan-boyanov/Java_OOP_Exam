package employee.service.salaryPromotions;

import department.data.Department;
import department.service.DepartmentService;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;


public class PercentagePromotionCalculator implements PromotionCalculator {
    @Override
    public void increaseSalary(Employee employee, Double percentage, DepartmentService departmentService, EmployeeServiceImpl employeeServiceImpl) {
        String employeDepartmentId = employee.getWorkInDepartment();

        if (percentage < 0) {
            throw new IllegalArgumentException("The promotion percentage needs to be a positive floating number!");
        } else if (employeDepartmentId.equals("N/A")) {
            double currentSalary = employee.getSalary();
            double newSalary = currentSalary + currentSalary * percentage / 100;
            employee.setSalary(newSalary);
        } else {
            Department employeeDepartment = departmentService.getDepartmentById(employeDepartmentId);
            Double departmentSpendBudget = departmentService.calculateSpendBudget(employeeServiceImpl, employeeDepartment);
            Double departmentBudget = employeeDepartment.getYearlyBudget();

            double currentSalary = employee.getSalary();
            double newSalary = currentSalary + currentSalary * percentage / 100;
            double newDepartmentBudget = departmentSpendBudget + newSalary - currentSalary;

            if (newDepartmentBudget <= departmentBudget) {
                employee.setSalary(newSalary);
            } else {
                throw new IllegalArgumentException("Department " + employeDepartmentId + "’s budget does not allow for such a high promotion!");
            }

        }


    }


}
