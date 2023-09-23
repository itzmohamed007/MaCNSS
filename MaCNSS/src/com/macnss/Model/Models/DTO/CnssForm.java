package com.macnss.Model.Models.DTO;

import java.sql.Ref;

enum RefundStatus {
    Pending,
    Rejected,
    Approved
}

public class CnssForm {
    private int id;
    private float totalPrice;
    private int attachmentsNumber;
    private RefundStatus status;

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
}
