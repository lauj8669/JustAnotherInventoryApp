package com.example.justanotherinventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class addNewItem extends AppCompatActivity {
    // instance variables
    private String name;
    private int quantity;
    private EditText nameInput;
    private EditText quantityInput;
    private TextView errorMsg;
    private Button submitButton;
    private Button cancelButton;

    // methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        nameInput = findViewById(R.id.itemName);
        quantityInput = findViewById(R.id.itemQuantity);
        errorMsg = findViewById(R.id.quantError);
        errorMsg.setVisibility(View.INVISIBLE);

        submitButton = findViewById(R.id.createButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
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
                    errorMsg.setVisibility(View.VISIBLE);
                } else {
                    // if not, send the information to Item.class and exit
                    quantity = Integer.parseInt(quantityInput.getText().toString());
                    Item.addNewItem(name, quantity);
                    startActivity(new Intent(v.getContext(), MainActivity.class));
                    finish();
                }
            }
        });

        cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
                finish();
            }
        });

    }
}
