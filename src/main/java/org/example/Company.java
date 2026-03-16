package org.example;

public class Company {
    //parent for this company, nullable when there are no parent
    private Company parent;
    private long employeeCount;

    public Company(Company parent, long employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }
}
