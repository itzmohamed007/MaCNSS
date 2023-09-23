package com.macnss.Model.Models;

enum DoctorType {
    GENERALIST,
    SPECIALIST
}

public class MedicalSummary {
    private DoctorType doctorType;
    private float price;

    public DoctorType getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(DoctorType doctorType) {
        this.doctorType = doctorType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
