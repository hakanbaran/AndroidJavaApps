package com.hakanbaran.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Number1Text;
    EditText Number2Text;
    EditText ResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Number1Text = findViewById(R.id.Number1Text);
        Number2Text = findViewById(R.id.Number2Text);
        ResultText = findViewById(R.id.ResultText);

    }

    public void sum(View view){

        if (Number1Text.getText().toString().matches("") || Number2Text.getText().toString().matches("")){
            ResultText.setText("Enter Number");
        } else {
            int Number1 =Integer.parseInt(Number1Text.getText().toString());
            int Number2 =Integer.parseInt(Number2Text.getText().toString());

            int result = Number1 + Number2;
            ResultText.setText("Result:" + result);
        }
    }

    public void deduct(View view){
        if (Number1Text.getText().toString().matches("") || Number2Text.getText().toString().matches("")){
            ResultText.setText("Enter Number");
        } else {
            int Number1 =Integer.parseInt(Number1Text.getText().toString());
            int Number2 =Integer.parseInt(Number2Text.getText().toString());

            int result = Number1 - Number2;
            ResultText.setText("Result:" + result);
        }

    }

    public void multiply(View view){
        if (Number1Text.getText().toString().matches("") || Number2Text.getText().toString().matches("")){
            ResultText.setText("Enter Number");
        } else {
            int Number1 =Integer.parseInt(Number1Text.getText().toString());
            int Number2 =Integer.parseInt(Number2Text.getText().toString());

            int result = Number1 * Number2;
            ResultText.setText("Result:" + result);
        }

    }
    public void divide(View view){
        if (Number1Text.getText().toString().matches("") || Number2Text.getText().toString().matches("")){
            ResultText.setText("Enter Number");
        } else {
            int Number1 =Integer.parseInt(Number1Text.getText().toString());
            int Number2 =Integer.parseInt(Number2Text.getText().toString());

            int result = Number1 / Number2;
            ResultText.setText("Result:" + result);
        }
    }
}