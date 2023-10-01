package com.macnss.Model.Models.DTO;

import java.util.Date;

public class Employee {
    private int registrationNumber;
    private String fullName;
    private String cin;
    private String address;
    private Date birth_date;
    private int companyNumber;

    @Override
    public String toString() {
        return "Employee{" +
                "registrationNumber=" + registrationNumber +
                ", fullName='" + fullName + '\'' +
                ", cin='" + cin + '\'' +
                ", address='" + address + '\'' +
                ", birth_date=" + birth_date +
                ", companyNumber=" + companyNumber +
                '}';
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }
}
