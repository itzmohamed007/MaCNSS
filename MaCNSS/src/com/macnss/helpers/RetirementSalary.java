package com.macnss.helpers;

public class RetirementSalary {
    public static float calcEmployeeRetirementSalary(int workDays, float baseSalary) {
        float retirementSalary = 0;
        // First case:
        if (isInNoIncrementRange(workDays)) {
            retirementSalary = (float) (baseSalary * 0.5);
        } else {
            // Second case:
            float baseRetirementSalary = (float) (baseSalary * 0.5);
            int baseSalaryIncrementPercentage = ((workDays - 3240) / 216);
            System.out.println(baseSalaryIncrementPercentage);
            if (baseSalaryIncrementPercentage > 20)
                baseSalaryIncrementPercentage = 20;
            retirementSalary = (float) (baseRetirementSalary + ((baseSalary * 0.01) * baseSalaryIncrementPercentage));
        }
        return retirementSalaryAcceptableRange(retirementSalary);
    }

    private static boolean isInNoIncrementRange(int workDays) {
        if (workDays >= 1320 && workDays <= 3240) {
            return true;
        }
        return false;
    }

    private static float retirementSalaryAcceptableRange(float retirementSalary) {
        if (retirementSalary > 6000)
            return 6000;
        else if (retirementSalary < 1000)
            return 1000;
        return retirementSalary;
    }
}
