package com.entity;

public class Contract {

    private int id;
    private String startDate;
    private String endDate;
    private double deposit;
    private int employeeId;
    private int customerPhone;
    private int facilityId;

    public Contract(int id, String startDate, String endDate, double deposit, int employeeId, int customerPhone, int facilityId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employeeId = employeeId;
        this.customerPhone = customerPhone;
        this.facilityId = facilityId;
    }

    public Contract() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int customerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerId) {
        this.customerPhone = customerId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }
}


