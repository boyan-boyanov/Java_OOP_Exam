package department.data;

import java.util.HashSet;

public class Department implements DepartmentInterface{
    private final String departmentID;

    private final String departmentName;

    private final Double yearlyBudget;

    HashSet<String> assignedEmployee = new HashSet<>();

    public Department(String departmentID, String departmentName, Double yearlyBudget) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.yearlyBudget = yearlyBudget;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public Double getYearlyBudget() {

        return yearlyBudget;
    }

    public void addEmployeeToList(String employeeId){
        assignedEmployee.add(employeeId);
    }

    public void removeEmployeeFromList(String employeeId){
        assignedEmployee.remove(employeeId);
    }


    public HashSet<String> getAssignedEmployee(){
        return assignedEmployee;
    }



}
