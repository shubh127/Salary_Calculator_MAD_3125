package com.example.assignment2;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int expVal = 0;
    int annualSalary = 0;

    private TextView tvExperience;
    private SeekBar sbExperience;
    private CheckBox cbJava;
    private CheckBox cbCSharp;
    private CheckBox cbPHP;
    private CheckBox cbPython;
    private CheckBox cbSwift;
    private TextView tvAnnualSalary;
    private TextView tvMonthlySalary;
    private RadioButton rbMaster;
    private RadioButton rbBSC;
    private RadioButton rbDiploma;
    private RadioButton rbSecSchool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        configViews();
    }

    private void initViews() {
        tvExperience = findViewById(R.id.tv_experience);
        sbExperience = findViewById(R.id.sb_experience);
        cbJava = findViewById(R.id.cb_java);
        cbCSharp = findViewById(R.id.cb_c_sharp);
        cbPHP = findViewById(R.id.cb_php);
        cbPython = findViewById(R.id.cb_python);
        cbSwift = findViewById(R.id.cb_swift);
        tvAnnualSalary = findViewById(R.id.tv_annual_salary);
        tvMonthlySalary = findViewById(R.id.tv_monthly_salary);
        rbMaster = findViewById(R.id.rb_master);
        rbBSC = findViewById(R.id.rb_bsc);
        rbDiploma = findViewById(R.id.rb_diploma);
        rbSecSchool = findViewById(R.id.rb_sec_school);
    }

    private void configViews() {
        rbBSC.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 70000;
            } else {
                annualSalary = annualSalary - 70000;
            }
            updateSalaryTxt();
        });

        rbDiploma.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 65000;
            } else {
                annualSalary = annualSalary - 65000;
            }
            updateSalaryTxt();
        });

        rbMaster.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 76000;
            } else {
                annualSalary = annualSalary - 76000;
            }
            updateSalaryTxt();
        });

        rbSecSchool.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 52000;
            } else {
                annualSalary = annualSalary - 52000;
            }
            updateSalaryTxt();
        });

        cbJava.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 2000;
            } else {
                annualSalary = annualSalary - 2000;
            }
            updateSalaryTxt();
        });


        cbCSharp.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 1500;
            } else {
                annualSalary = annualSalary - 1500;
            }
            updateSalaryTxt();
        });


        cbPHP.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 1000;
            } else {
                annualSalary = annualSalary - 1000;
            }
            updateSalaryTxt();
        });


        cbPython.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 3000;
            } else {
                annualSalary = annualSalary - 3000;
            }
            updateSalaryTxt();
        });


        cbSwift.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                annualSalary = annualSalary + 3000;
            } else {
                annualSalary = annualSalary - 3000;
            }
            updateSalaryTxt();
        });

        sbExperience.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                expVal = i;
                tvExperience.setText(String.format(Locale.getDefault(),
                        "Experience(in years): %d", expVal));

                updateSalaryTxt();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //no op
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //no op
            }
        });
    }

    private void updateSalaryTxt() {
        int finalSalary;
        if (expVal > 4) {
            finalSalary = annualSalary + (300 * expVal);
        } else {
            finalSalary = annualSalary + (200 * expVal);
        }
        tvAnnualSalary.setText(String.format(Locale.getDefault(),
                "Annual Salary: $%d", finalSalary));
        tvMonthlySalary.setText(String.format(Locale.getDefault(),
                "Monthly Salary: $%d", finalSalary / 12));
    }
}