package com.example.bmi_calculator;

import android.widget.EditText;

public class CalcBmi {
    private double bmi;
    public double returnBmi(double weight, double height) {
        bmi = (weight * 703) / (height * height);
        return bmi;
    }
}
