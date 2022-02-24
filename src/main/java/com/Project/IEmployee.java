package com.Project;

public interface IEmployee {
    void printEmployeeDetails();
    int getCost();
    String getFullName();
    void setFullName(String fullName);
    void setSalary(int salary);
    IEmployee findEmployee(String name);
}
