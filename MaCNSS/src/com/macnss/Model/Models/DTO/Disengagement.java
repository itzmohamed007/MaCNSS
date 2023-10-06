package com.macnss.Model.Models.DTO;

public class Disengagement {
    private int id;
    private int patientNumber;
    private String companyNumber;
    private int workedDays;
    private float salary;
    private int salaryContribution;
    private EmployeeStatus status;

    @Override
    public String toString() {
        return "Disengagement{" +
                "id=" + id +
                ", patientNumber=" + patientNumber +
                ", companyNumber='" + companyNumber + '\'' +
                ", workedDays=" + workedDays +
                ", salary=" + salary +
                ", salaryContribution=" + salaryContribution +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getSalaryContribution() {
        return salaryContribution;
    }

    public void setSalaryContribution(int salaryContribution) {
        this.salaryContribution = salaryContribution;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
}
