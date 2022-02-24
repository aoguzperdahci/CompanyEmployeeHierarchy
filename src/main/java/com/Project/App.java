package com.Project;

public class App {
    
    public static void main(String[] args) {

        SetupDataTemplate creator = new SetupFromFile();
        Manager root = creator.setup();

        findAndPrintEmployeeDetails(root, "Mustafa Turksever");
        findAndPrintEmployeeDetails(root, "Oguz Demir");
        findAndPrintEmployeeDetails(root, "Ahmet Egeli");

    }

    public static void findAndPrintEmployeeDetails(Manager root, String name) {
        IEmployee employee = root.findEmployee(name);
        System.out.println("-------------------------------------");

        if (employee == null) {
            System.out.println("Employee not found...");
            return;
        }

        System.out.println(employee.getFullName() + " total cost: " + employee.getCost());
        System.out.println("");
        employee.printEmployeeDetails();
    }
    
}
