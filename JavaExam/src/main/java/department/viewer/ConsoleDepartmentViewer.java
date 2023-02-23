package department.viewer;

import department.data.Department;
import department.service.DepartmentService;
import employee.service.EmployeeServiceImpl;

import java.util.HashSet;

public class ConsoleDepartmentViewer implements DepartmentView {
    @Override
    public String viewDepartment(Department departmentToShow, DepartmentService departmentService, EmployeeServiceImpl employeeServiceImpl) {
        double yearlyBudget = departmentToShow.getYearlyBudget();
        int yearlyBudgetInt = (int) yearlyBudget;
        HashSet<String> allEmployees = departmentToShow.getAssignedEmployee();
        String result = String.join(", ", allEmployees);
        double spendBudget = departmentService.calculateSpendBudget(employeeServiceImpl, departmentToShow);
        int spendBudgetInt = (int) spendBudget;
        int leftOverBudget = yearlyBudgetInt - spendBudgetInt;

        return "Department: " + departmentToShow.getDepartmentName() +
                System.getProperty("line.separator") +
                "Budget: " + yearlyBudgetInt + "$/year." +
                System.getProperty("line.separator") +
                "Not allocated: " + leftOverBudget +
                System.getProperty("line.separator") +
                "Employees: " + result;
    }
}

