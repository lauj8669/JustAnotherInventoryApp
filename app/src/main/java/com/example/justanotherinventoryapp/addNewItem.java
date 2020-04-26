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
    private Button submitButton;
    private TextView errorMsg;

    // methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        nameInput = findViewById(R.id.itemName);
        quantityInput = findViewById(R.id.itemQuantity);
        submitButton = findViewById(R.id.createButton);
        errorMsg = findViewById(R.id.quantError);
        errorMsg.setVisibility(View.INVISIBLE);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                Boolean isItInt = true;
                try {
                    quantity = Integer.parseInt(quantityInput.getText().toString());
                } catch(Exception e) {
                    isItInt = false;
                }
                if (!(isItInt)) {
                    errorMsg.setVisibility(View.VISIBLE);
                } else {
                    quantity = Integer.parseInt(quantityInput.getText().toString());
                    startActivity(new Intent(v.getContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }
}
