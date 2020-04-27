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
    private TextView errorMsg2;
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
        errorMsg2 = findViewById(R.id.duplicateItemError);
        errorMsg2.setVisibility(View.INVISIBLE);

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
                if (!(isItInt) || quantity <= 0) {
                    errorMsg.setVisibility(View.VISIBLE);
                } else {
                    // if not, send the information to Item.class and exit
                    quantity = Integer.parseInt(quantityInput.getText().toString());
                    //Add the item to the private list.
                    if (!(Item.addNewItem(name, quantity))) {
                        //Alert the user that the item they added is already in inventory and thus not added.
                        errorMsg2.setVisibility(View.VISIBLE);
                    } else {
                        startActivity(new Intent(v.getContext(), MainActivity.class));
                        finish();
                    }
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
