package com.macnss.Model.Models.DTO;

public class Company {
    private String registrationNumber;
    private String name;
    private CompanyType type;

    @Override
    public String toString() {
        return "Company{" +
                "registration_number=" + registrationNumber +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }
}
