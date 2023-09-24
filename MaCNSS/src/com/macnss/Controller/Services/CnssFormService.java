package com.macnss.Controller.Services;

import com.macnss.Model.Models.MedicalSummary;

import java.util.HashMap;

public class CnssFormService {
    public static float calcRefundAmount(HashMap<String, Float> medicines, MedicalSummary[] documents, int totalPrice) {
        float refundAmount = 0;
        for (MedicalSummary document : documents) {
            refundAmount += document.getPrice();
        }

        return refundAmount;
    }
}
