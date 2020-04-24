package com.example.justanotherinventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addNewItem extends AppCompatActivity {
    String name;
    int quantity;
    EditText nameInput;
    EditText quantityInput;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        nameInput = (EditText) findViewById(R.id.itemName);
        quantityInput = (EditText) findViewById(R.id.itemQuantity);
        submitButton = (Button) findViewById(R.id.submitInfo);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                quantity = Integer.valueOf(quantityInput.getText().toString());
            }
        });
    }
}