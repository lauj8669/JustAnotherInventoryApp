package com.example.justanotherinventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyItem extends AppCompatActivity {

    // instance variables
    private String name;
    private int quantity;
    private EditText nameInput;
    private EditText quantityInput;
    private TextView editError;
    private Button submitButton2;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_item);

        nameInput = findViewById(R.id.editName);
        quantityInput = findViewById(R.id.editQuantity);
        editError = findViewById(R.id.editError);
        editError.setVisibility(View.INVISIBLE);

        getData();
        setData();

        submitButton2 = findViewById(R.id.editSubmit);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                Boolean isItInt = true;
                // checking if the user inputted a number for the quantity
                try {
                    quantity = Integer.parseInt(quantityInput.getText().toString());
                } catch(Exception e) {
                    isItInt = false;
                }
                // if yes, display the error message
                if (!(isItInt)) {
                    editError.setVisibility(View.VISIBLE);
                } else {
                    // if not, send the information to Item.class and exit
                    quantity = Integer.parseInt(quantityInput.getText().toString());
                    // Item.modifyItemQuantity(name, quantity);
                    startActivity(new Intent(v.getContext(), MainActivity.class));
                    finish();
                }
            }
        });

        cancelButton = findViewById(R.id.editCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
                finish();
            }
        });

    }

    private String data1, data2;

    private void getData() {
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
        } else {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        nameInput.setText(data1);
        quantityInput.setText(data2);
    }
}
