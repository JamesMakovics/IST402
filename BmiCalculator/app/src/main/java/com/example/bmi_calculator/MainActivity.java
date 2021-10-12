package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double user_weight,user_height;
    private CalcBmi calBmi;
    EditText weight;
    EditText height;
    TextView dispBmiMsg; //@+id/disp_bmi_msg
    TextView yourBMIString; //@+id/what_is_BMI
    TextView dispBmiVal; //@+id/display_bmi
    ImageView dispWarning; //@+id/warning_msg

    Button cButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calBmi = new CalcBmi();
        setContentView(R.layout.activity_main);

        weight = (EditText) findViewById(R.id.Weight);
        height = (EditText) findViewById(R.id.HeightIn);
        dispBmiMsg = (TextView) findViewById(R.id.disp_bmi_msg);
        yourBMIString = (TextView) findViewById(R.id.what_is_BMI);
        dispBmiVal = (TextView) findViewById(R.id.display_bmi);
        dispWarning = (ImageView) findViewById(R.id.warning_msg);

        dispBmiMsg.setVisibility(View.INVISIBLE);
        yourBMIString.setVisibility(View.INVISIBLE);
        dispBmiVal.setVisibility(View.INVISIBLE);

        cButton = (Button) findViewById(R.id.CalcButton);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_weight = Double.valueOf(weight.getText().toString());
                user_height = Double.valueOf(height.getText().toString());
                dispBmi(user_height, user_weight);
            }
        });

    }

    public void dispBmi(Double user_height, Double user_weight) {
        String healthyBMI = "Your BMI is Average";
        String overBMI = "Your BMI is Over Weight";
        String obeseBMI = "Your BMI is Obese";
        String underBMI = "Your BMI is Under Weight";

        double calcBMI = calBmi.returnBmi(user_weight, user_height);
        if (18.5 <= calcBMI && calcBMI <= 24.9){
            dispWarning.setImageResource(R.drawable.check_mark);
            dispBmiMsg.setText(healthyBMI);
            dispBmiVal.setText(String.valueOf(calcBMI));
            dispBmiMsg.setVisibility(View.VISIBLE);
            yourBMIString.setVisibility(View.VISIBLE);
            dispBmiVal.setVisibility(View.VISIBLE);
        }
        else if (25 <= calcBMI && calcBMI <= 29.9){
            dispWarning.setImageResource(R.drawable.caution_sign);
            dispBmiMsg.setText(overBMI);
            dispBmiVal.setText(String.valueOf(calcBMI));
            dispBmiMsg.setVisibility(View.VISIBLE);
            yourBMIString.setVisibility(View.VISIBLE);
            dispBmiVal.setVisibility(View.VISIBLE);
        }
        else if (30 <= calcBMI){
            dispWarning.setImageResource(R.drawable.warning_sign);
            dispBmiMsg.setText(obeseBMI);
            dispBmiVal.setText(String.valueOf(calcBMI));
            dispBmiMsg.setVisibility(View.VISIBLE);
            yourBMIString.setVisibility(View.VISIBLE);
            dispBmiVal.setVisibility(View.VISIBLE);
        }
        else if (calcBMI < 18.5){
            dispWarning.setImageResource(R.drawable.warning_sign);
            dispBmiMsg.setText(underBMI);
            dispBmiVal.setText(String.valueOf(calcBMI));
            dispBmiMsg.setVisibility(View.VISIBLE);
            yourBMIString.setVisibility(View.VISIBLE);
            dispBmiVal.setVisibility(View.VISIBLE);
        }
    }
}