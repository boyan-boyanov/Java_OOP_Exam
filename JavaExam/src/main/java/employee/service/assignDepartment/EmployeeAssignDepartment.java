package employee.service.assignDepartment;

import department.data.Department;
import employee.data.Employee;
import employee.service.EmployeeServiceImpl;

import java.util.HashSet;

public class EmployeeAssignDepartment implements AssignDepartment {
    Double currentSalary = 0.0;

    @Override
    public void moveToDepartment(Employee employee, Department assignToDepartment, Double spendBudgetOnNewDepartment) {

        Double departmentBudget = assignToDepartment.getYearlyBudget();
        Double employeeSalary = employee.getSalary();
        double newDepartmentBudget = spendBudgetOnNewDepartment + employeeSalary;

        if (newDepartmentBudget <= departmentBudget) {
            assignToDepartment.addEmployeeToList(employee.getEmployeeID());
            employee.setWorkInDepartment(assignToDepartment.getDepartmentID());
        } else {
            throw new IllegalArgumentException("Unable to add employee " + employee.getEmployeeID() + " to department "
                    + assignToDepartment.getDepartmentID() + " as there is not enough budget!");
        }

    }

    @Override
    public void moveToDepartment(Employee employee, Department assignToDepartment, Department currentDepartment, Double spendBudgetOnNewDepartment) {
        Double departmentBudget = assignToDepartment.getYearlyBudget();
        Double employeeSalary = employee.getSalary();
        double newDepartmentBudget = spendBudgetOnNewDepartment + employeeSalary;
        if (newDepartmentBudget <= departmentBudget) {

            assignToDepartment.addEmployeeToList(employee.getEmployeeID());
            employee.setWorkInDepartment(assignToDepartment.getDepartmentID());
            currentDepartment.removeEmployeeFromList(employee.getEmployeeID());

        } else {
            throw new IllegalArgumentException("Unable to add employee " + employee.getEmployeeID() + " to department "
                    + assignToDepartment.getDepartmentID() + "as there is not enough budget!");
        }
    }


}
