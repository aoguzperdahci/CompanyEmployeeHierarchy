package com.Project;

public class ManagerIterator implements Iterator {

    private IEmployee[] employees;
    private int position = 0;

    public ManagerIterator(IEmployee[] employees) {
        this.employees = employees;
    }

    @Override
    public boolean hasNext() {
        if (position >= employees.length || employees[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public IEmployee next() {
        IEmployee employee = employees[position++];
        return employee;
    }

    public void updatePosition(int deletedPosition) {
        if (position > deletedPosition) {
            position--;
        }
    }

    @Override
    public void reset() {
        position = 0;
    }

}
