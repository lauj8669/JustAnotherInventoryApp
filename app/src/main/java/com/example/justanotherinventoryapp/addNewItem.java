package com.example.justanotherinventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addNewItem extends AppCompatActivity {
    // instance variables
    String name;
    int quantity;
    EditText nameInput;
    EditText quantityInput;
    Button submitButton;

    // methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        nameInput = findViewById(R.id.itemName);
        quantityInput = findViewById(R.id.itemQuantity);
        submitButton = findViewById(R.id.createButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                quantity = Integer.parseInt(quantityInput.getText().toString());
                startActivity(new Intent(v.getContext(), MainActivity.class));
                finish();
            }
        });
    }
}
