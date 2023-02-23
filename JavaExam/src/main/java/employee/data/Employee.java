package employee.data;

public class Employee {

    private final String employeeID;
    private final String firstName;

    private final String lastName;

    private Double salary;

    private String workInDepartment;


    public Employee(String employeeID, String firstName, String lastName, Double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.workInDepartment = "N/A";
    }

    public String getEmployeeID() {

        return employeeID;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public Double getSalary() {

        return salary;
    }

    public String getWorkInDepartment(){

        return workInDepartment;
    }
    public void setWorkInDepartment(String workInDepartment) {

        this.workInDepartment = workInDepartment;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }
}
