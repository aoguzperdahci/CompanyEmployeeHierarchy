package com.Project;

public class Officer implements IEmployee {

    private String fullName;
    private int salary;

    public Officer(String fullName, int salary) {
        this.fullName = fullName;
        setSalary(salary);
    }

    @Override
    public void printEmployeeDetails() {
        System.out.println("-Officer: " + fullName);
    }

    @Override
    public int getCost() {
        return salary;
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
        } else {
            return null;
        }
    }

}
