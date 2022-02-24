package com.Project;

public class Manager implements IEmployee, IterableCollection {

    private String fullName;
    private int salary;
    private IEmployee[] employeesControl;
    private int numberOfEmployees = 0;
    private static int printLevel = 0;
    private ManagerIterator[] iterators;
    private int iteratorConter = 0;

    public Manager(String fullName, int salary) {
        this.fullName = fullName;
        setSalary(salary);
        employeesControl = new IEmployee[128];
        iterators = new ManagerIterator[32];
    }

    public void addEmployee(IEmployee employee) {
        employeesControl[numberOfEmployees++] = employee;
    }

    public void removeEmpoloyee(IEmployee employee) {
        int found = -1;

        for (int i = 0; i < numberOfEmployees; i++) {
            if (found != -1) {
                employeesControl[i - 1] = employeesControl[i];
            } else if (employee.getClass() == employeesControl[i].getClass() && employee.equals(employeesControl[i])) {
                found = i;
            }
        }

        if (found != -1) {
            //iterators uses array so, the position may be inaccurate when a deletion made. Check and correct the positions 
            employeesControl[--numberOfEmployees] = null;
            for (int i = 0; i < iteratorConter; i++) {
                iterators[i].updatePosition(0);
            }
        }

    }

    @Override
    public void printEmployeeDetails() {
        System.out.println("+Manager: " + fullName);
        printLevel++;
        String tab = "\t";
        String prefix = tab.repeat(printLevel);

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.print(prefix);
            employeesControl[i].printEmployeeDetails();
        }

        printLevel--;
    }

    @Override
    public int getCost() {
        int total = salary;

        for (int i = 0; i < numberOfEmployees; i++) {
            total += employeesControl[i].getCost();
        }

        return total;
    }

    @Override
    public Iterator createIterator() {
        ManagerIterator iterator = new ManagerIterator(employeesControl);
        iterators[iteratorConter++] = iterator;
        return iterator;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            salary = 0;
        }
    }

    @Override
    public IEmployee findEmployee(String name) {

        if (fullName.contains(name)) {
            return this;
        }

        for (int i = 0; i < numberOfEmployees; i++) {
            IEmployee employee = employeesControl[i].findEmployee(name);
            if (employee != null) {
                return employee;
            }
        }

        return null;
    }

}
