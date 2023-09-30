package com.macnss.Model.Models.DTO;

public class Company {
    private int registration_number;
    private String name;
    private CompanyType type;

    @Override
    public String toString() {
        return "Company{" +
                "registration_number=" + registration_number +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    public int getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(int registration_number) {
        this.registration_number = registration_number;
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
