package com.Project;

public abstract class SetupDataTemplate {

    protected Manager[] managers;
    protected int managerCount = 0;
    
    public SetupDataTemplate() {
        managers = new Manager[64];
    }

    public final Manager setup(){
        String[][] records = readAll();
        return createStructure(records);
    }

    protected abstract String[][] readAll();

    //default method: only works if the input format is [ ["D or M", "fullname", "salary", "managersName"], ... ] 
    protected Manager createStructure(String[][] records){

        for (String[] record : records) {

            if (record[0] == null || record[1] == null || record[2] == null || record[3] == null) {
                break;
            }

            IEmployee employee;

            if (record[0].equals("D")) {//if it is a manager, create a manager object and store it for further references
                employee = new Manager(record[1], Integer.parseInt(record[2]));
                managers[managerCount++] = (Manager) employee;
            } else {//else create a officer
                employee = new Officer(record[1], Integer.parseInt(record[2]));
            }

            for (int i = 0; i < managerCount; i++) {
                //Check all the managers so far created and see if there is one that manages the employee.
                if(managers[i].getFullName().contains(record[3])) {
                    managers[i].addEmployee(employee);
                    break;
                }
            }
        }
        //returns the root object
        return managers[0];
    }
}
