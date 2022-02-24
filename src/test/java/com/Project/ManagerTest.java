package com.Project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ManagerTest {

    @Test
    public void shouldAddEmployeeToManager() { 
        Manager manager = new Manager("Steve Jobs", 1);
        Officer officer = new Officer("Ada Lovelace", 15000);
        Officer officer2 = new Officer("Steve Wozniak", 13000);
        Officer officer3 = new Officer("Steve Capps", 11000);

        manager.addEmployee(officer);
        manager.addEmployee(officer2);
        manager.addEmployee(officer3);

        Iterator iterator = manager.createIterator();

        int count = 0; 
        while(iterator.hasNext()){
            iterator.next();
            count++;
        }

        assertEquals(3, count);
    }

    @Test
    public void shouldRemoveEmployeeFromManager() { 
        Manager manager = new Manager("Steve Jobs", 1);
        Officer officer = new Officer("Ada Lovelace", 15000);
        Officer officer2 = new Officer("Steve Wozniak", 13000);
        Officer officer3 = new Officer("Steve Capps", 11000);

        manager.addEmployee(officer);
        manager.addEmployee(officer2);
        manager.addEmployee(officer3);

        Iterator iterator = manager.createIterator();

        while(iterator.hasNext()){
            IEmployee employee = iterator.next();
            manager.removeEmpoloyee(employee);
            
        }

        Iterator iterator1 = manager.createIterator();

        int count = 0; 
        while(iterator1.hasNext()){
            iterator1.next();
            count++;
        }

        assertEquals(0, count);
    }


    @Test
    public void shouldCalculateCostManager() {
        Manager manager = new Manager("Steve Jobs", 1);
        Manager manager2 = new Manager("Tim Cook", 50000);
        Officer officer = new Officer("Ada Lovelace", 15000);
        Officer officer2 = new Officer("Steve Wozniak", 13000);
        Officer officer3 = new Officer("Steve Capps", 11000);

        manager.addEmployee(officer);
        manager.addEmployee(manager2);
        manager2.addEmployee(officer2);
        manager2.addEmployee(officer3);

        int cost = manager.getCost();

        assertEquals(89001, cost);
    }

}
