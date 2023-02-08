package com.example.lab2a_tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lab2a_tipcalculator.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.totalBillInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextInputEditText editText = binding.totalBillInput;
                String totalBillInput = editText.getText().toString();

                if (totalBillInput.isEmpty() || totalBillInput.equals("0")) {
                    binding.output.setText(getResources().getString(R.string.invalidInput));
                }

                try {
                    double totalBill = Double.parseDouble(totalBillInput);
                } catch (NumberFormatException e) {
                    binding.output.setText(getResources().getString(R.string.invalidInput));
                }
            }
        });

        binding.tipPercentageInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextInputEditText editText = binding.tipPercentageInput;
                String tipPercentageInput = editText.getText().toString();

                if (tipPercentageInput.isEmpty() || tipPercentageInput.equals("0")) {
                    binding.output.setText(getResources().getString(R.string.invalidInput));
                }
                try {
                    double totalTip = Double.parseDouble(tipPercentageInput);
                } catch (NumberFormatException e) {
                    binding.output.setText(getResources().getString(R.string.invalidInput));
                }
            }
        });

        binding.numberOfPeopleInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextInputEditText editText = binding.numberOfPeopleInput;
                String numberOfPeopleInput = editText.getText().toString();

                if (numberOfPeopleInput.isEmpty() || numberOfPeopleInput.equals("0")) {
                    binding.output.setText(getResources().getString(R.string.invalidInput));
                }
                try {
                    double totalPeople = Double.parseDouble(numberOfPeopleInput);
                } catch (NumberFormatException e) {
                    binding.output.setText(getResources().getString(R.string.invalidInput));
                }
            }
        });

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double totalBill = Double.parseDouble(binding.totalBillInput.getText().toString());
                double totalTip = Double.parseDouble(binding.tipPercentageInput.getText().toString());
                double totalPeople = Double.parseDouble(binding.numberOfPeopleInput.getText().toString());

                double result = calculateOutput(totalBill, totalTip, totalPeople);
                binding.output.setText(String.format("$%.2f", result));

            }
        });
    }
        private double calculateOutput(double totalBill, double totalTip, double totalPeople) {
            double tip = totalBill * (totalTip / 100);
            double totalAndTip = totalBill + tip;
            return totalAndTip / totalPeople;
        }
}