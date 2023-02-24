package org.example;

import department.data.Department;
import department.persistence.DepartmentPersistenceInMemory;
import department.service.DepartmentService;
import department.service.updateDepartment.UpdateDepartment;
import department.viewer.ConsoleDepartmentViewer;
import employee.data.Employee;
import employee.persistence.EmployeePersistenceInMemory;
import employee.service.EmployeeServiceImpl;
import employee.service.assignDepartment.EmployeeAssignDepartment;
import department.service.calculateBudget.CalculateDepartmentSpendBudget;
import employee.service.salaryPromotions.PercentagePromotionCalculator;
import employee.viewer.ConsoleEmployeeViewer;
import printers.WriteAfterCreateObject;
import printers.WriteLogFile;
import printers.Printer;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Employee> hiredEmployees = new HashMap<>();

        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl(new EmployeePersistenceInMemory(),
                new ConsoleEmployeeViewer(), new PercentagePromotionCalculator(), new EmployeeAssignDepartment());

        DepartmentService departmentService = new DepartmentService(new DepartmentPersistenceInMemory(),
                new CalculateDepartmentSpendBudget(), new ConsoleDepartmentViewer(), new UpdateDepartment());

        WriteLogFile writeLogFile = new WriteLogFile();
        WriteAfterCreateObject writeAfterCreateObject = new WriteAfterCreateObject();

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("End")) {
            String command = input[0];

            switch (command) {
                case "CreateDepartment":
                    try {
                        departmentService.createDepartment(input);
                        writeAfterCreateObject.saveToFile("Department Id: " + input[1] + " Department name: " + input[2] + " Department budget: " + input[3], "departments");
                    } catch (IllegalArgumentException exception) {
                        Printer.Print(exception.getMessage());
                        writeLogFile.write(exception.getMessage());
                    }
                    break;
                case "HireEmployee":
                    try {
                        employeeServiceImpl.hire(input);
                        writeAfterCreateObject.saveToFile("Name: " + input[2] + " " + input[3] + "Salary: " + input[4], "employees");
                    } catch (IllegalArgumentException exception) {
                        Printer.Print(exception.getMessage());
                        writeLogFile.write(exception.getMessage());
                    }
                    break;
                case "AssignDepartment":
                    String employeeId = input[1];
                    String departmentId = input[2];

                    try {
                        Employee currentEmployee = employeeServiceImpl.getEmployeeById(employeeId);
                        Department assignToDepartment = departmentService.getDepartmentById(departmentId);

                        String currentDepartmentId = currentEmployee.getWorkInDepartment();

                        Double spendBudgetOnNewDepartment = departmentService.calculateSpendBudget(employeeServiceImpl, assignToDepartment);
                        if (currentDepartmentId.equals("N/A")) {
                            employeeServiceImpl.moveToDepartment(currentEmployee, assignToDepartment, spendBudgetOnNewDepartment);
                        } else {
                            Department currentDepartment = departmentService.getDepartmentById(currentDepartmentId);
                            employeeServiceImpl.moveToDepartment(currentEmployee, assignToDepartment, currentDepartment, spendBudgetOnNewDepartment);
                        }
                    } catch (IllegalArgumentException exception) {
                        Printer.Print(exception.getMessage());
                        writeLogFile.write(exception.getMessage());

                    }
                    break;
                case "PromoteEmployee":
                    employeeId = input[1];
                    Double percentage = Double.parseDouble(input[2]);

                    try {
                        Employee currentEmployee = employeeServiceImpl.getEmployeeById(employeeId);
                        employeeServiceImpl.promote(currentEmployee, percentage, departmentService, employeeServiceImpl);
                    } catch (IllegalArgumentException exception) {
                        Printer.Print(exception.getMessage());
                        writeLogFile.write(exception.getMessage());
                    }
                    break;
                case "ShowEmployee":
                    employeeId = input[1];
                    try {
                        Employee currentEmployee = employeeServiceImpl.getEmployeeById(employeeId);
                        String employeeData = employeeServiceImpl.presentEmployeeData(currentEmployee, departmentService);
                        Printer.Print(employeeData);
                        writeLogFile.write(employeeData);
                    } catch (IllegalArgumentException exception) {
                        Printer.Print(exception.getMessage());
                        writeLogFile.write(exception.getMessage());
                    }
                    break;
                case "ShowDepartment":
                    departmentId = input[1];
                    try {
                        Department departmentToShow = departmentService.getDepartmentById(departmentId);
                        String departmentData = departmentService.viewDepartment(departmentToShow, departmentService, employeeServiceImpl);
                        Printer.Print(departmentData);
                        writeLogFile.write(departmentData);
                    } catch (IllegalArgumentException exception) {
                        Printer.Print(exception.getMessage());
                        writeLogFile.write(exception.getMessage());
                    }
                    break;
                case "UpdateDepartment":
                    try {
                        departmentId = input[1];
                        String newDepartmentName = input[2];
                        Double newDepartmentBudget = Double.parseDouble(input[3]);
                        Department currentDepartment = departmentService.getDepartmentById(departmentId);
                        departmentService.updateDepartment(departmentId, newDepartmentName, newDepartmentBudget, currentDepartment, employeeServiceImpl);
                    } catch (IllegalArgumentException exception) {
                        Printer.Print(exception.getMessage());
                        writeLogFile.write(exception.getMessage());
                    }

                    break;
                default:
                    String message = "Invalid command, choose one of this:" +
                            System.getProperty("line.separator") +
                            "CreateDepartment, UpdateDepartment, ShowDepartment" +
                            System.getProperty("line.separator") +
                            "HireEmployee, AssignDepartment, PromoteEmployee, ShowEmployee";
                    Printer.Print(message);
                    writeLogFile.write(message);
                    break;
            }


            input = scanner.nextLine().split("\\s+");
        }

//        Employee employee = new Employee("123asd", "Georgi", "petrov", 222.33);
//        hiredEmployees.put(employee.getEmployeeID(), employee);
//
        System.out.println(hiredEmployees);


    }


}