package com.example.model.entity;

import java.sql.Timestamp;

public class GeneralObject {
    private int contractId;
    private Timestamp contractStartDate;
    private Timestamp contractEndDate;
    private double contractDeposit;
    private int contractEmployeeId;
    private int contractCustomerId;
    private int contractFacilityId;
    private boolean contractIsDelete;
    private int customerId;
    private String customerName;
    private boolean customerGender;
    private String customerDateOfBirth;
    private String customerIdCard;
    private String customerPhoneNumber;
    private String customerEmail;
    private String customerAddress;
    private boolean customerIsDelete;
    private int contractDetailId;
    private int attachFacilityId;
    private int quantity;
    private int contractDetailIsDelete;
    private String attachFacilityName;
    private double attachFacilityCost;
    private String attachFacilityUnit;
    private String attachFacilityStatus;
    private boolean attachFacilityIsDelete;

    public GeneralObject(int contractId, Timestamp contractStartDate, Timestamp contractEndDate, double contractDeposit,
                         int contractEmployeeId, int contractCustomerId, int contractFacilityId, boolean contractIsDelete,
                         int customerId, String customerName, boolean customerGender, String customerDateOfBirth,
                         String customerIdCard, String customerPhoneNumber, String customerEmail, String customerAddress,
                         boolean customerIsDelete, int contractDetailId, int attachFacilityId, int quantity, int contractDetailIsDelete,
                         String attachFacilityName, double attachFacilityCost, String attachFacilityUnit, String attachFacilityStatus,
                         boolean attachFacilityIsDelete) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractEmployeeId = contractEmployeeId;
        this.contractCustomerId = contractCustomerId;
        this.contractFacilityId = contractFacilityId;
        this.contractIsDelete = contractIsDelete;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerIdCard = customerIdCard;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerIsDelete = customerIsDelete;
        this.contractDetailId = contractDetailId;
        this.attachFacilityId = attachFacilityId;
        this.quantity = quantity;
        this.contractDetailIsDelete = contractDetailIsDelete;
        this.attachFacilityName = attachFacilityName;
        this.attachFacilityCost = attachFacilityCost;
        this.attachFacilityUnit = attachFacilityUnit;
        this.attachFacilityStatus = attachFacilityStatus;
        this.attachFacilityIsDelete = attachFacilityIsDelete;
    }

    public int getContractId() {
        return contractId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getAttachFacilityId() {
        return attachFacilityId;
    }

    public Timestamp getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Timestamp contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Timestamp getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Timestamp contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public int getContractEmployeeId() {
        return contractEmployeeId;
    }

    public void setContractEmployeeId(int contractEmployeeId) {
        this.contractEmployeeId = contractEmployeeId;
    }

    public int getContractCustomerId() {
        return contractCustomerId;
    }

    public void setContractCustomerId(int contractCustomerId) {
        this.contractCustomerId = contractCustomerId;
    }

    public int getContractFacilityId() {
        return contractFacilityId;
    }

    public void setContractFacilityId(int contractFacilityId) {
        this.contractFacilityId = contractFacilityId;
    }

    public boolean isContractIsDelete() {
        return contractIsDelete;
    }

    public void setContractIsDelete(boolean contractIsDelete) {
        this.contractIsDelete = contractIsDelete;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public boolean isCustomerIsDelete() {
        return customerIsDelete;
    }

    public void setCustomerIsDelete(boolean customerIsDelete) {
        this.customerIsDelete = customerIsDelete;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getContractDetailIsDelete() {
        return contractDetailIsDelete;
    }

    public void setContractDetailIsDelete(int contractDetailIsDelete) {
        this.contractDetailIsDelete = contractDetailIsDelete;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public double getAttachFacilityCost() {
        return attachFacilityCost;
    }

    public void setAttachFacilityCost(double attachFacilityCost) {
        this.attachFacilityCost = attachFacilityCost;
    }

    public String getAttachFacilityUnit() {
        return attachFacilityUnit;
    }

    public void setAttachFacilityUnit(String attachFacilityUnit) {
        this.attachFacilityUnit = attachFacilityUnit;
    }

    public String getAttachFacilityStatus() {
        return attachFacilityStatus;
    }

    public void setAttachFacilityStatus(String attachFacilityStatus) {
        this.attachFacilityStatus = attachFacilityStatus;
    }

    public boolean isAttachFacilityIsDelete() {
        return attachFacilityIsDelete;
    }

    public void setAttachFacilityIsDelete(boolean attachFacilityIsDelete) {
        this.attachFacilityIsDelete = attachFacilityIsDelete;
    }
}
