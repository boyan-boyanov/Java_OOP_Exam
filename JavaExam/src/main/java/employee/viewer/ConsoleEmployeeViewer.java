package employee.viewer;

import department.data.Department;
import department.service.DepartmentService;
import employee.data.Employee;

public class ConsoleEmployeeViewer implements EmployeeViewer {
    @Override
    public String viewEmployee(Employee employee, DepartmentService departmentService) {
        String departmentName;
        if(employee.getWorkInDepartment().equals("N/A")){
            departmentName = employee.getWorkInDepartment();
        }else{
            Department currentDepartment = departmentService.getDepartmentById(employee.getWorkInDepartment());
            departmentName = currentDepartment.getDepartmentName();
        }


        String employeeString = String.format("Employee ID: %s, name: %s %s, Department: %s, Salary: %.2f",
                employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(), departmentName, employee.getSalary());
        return employeeString;
    }
}
