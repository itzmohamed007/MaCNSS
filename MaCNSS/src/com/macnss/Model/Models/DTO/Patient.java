package com.macnss.Model.Models.DTO;

import java.time.LocalDate;
import java.util.Date;

public class Patient {
    private int registrationNumber;
    private String fullName;
    private String cin;
    private String address;
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "Patient{" +
                "registrationNumber=" + registrationNumber +
                ", fullName='" + fullName + '\'' +
                ", cin='" + cin + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
