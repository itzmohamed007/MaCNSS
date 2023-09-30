package com.macnss.Model.Models.DTO;

import java.sql.Ref;

public class CnssForm {
    private int id;
    private float totalPrice;
    private int attachmentsNumber;
    private RefundStatus status;

    @Override
    public String toString() {
        return "CnssForm{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", attachmentsNumber=" + attachmentsNumber +
                ", status='" + status + '\'' +
                ", patientNumber=" + patientNumber +
                '}';
    }

    private int patientNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAttachmentsNumber() {
        return attachmentsNumber;
    }

    public void setAttachmentsNumber(int attachmentsNumber) {
        this.attachmentsNumber = attachmentsNumber;
    }

    public RefundStatus getStatus() {
        return status;
    }

    public void setStatus(RefundStatus status) {
        this.status = status;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }
}
