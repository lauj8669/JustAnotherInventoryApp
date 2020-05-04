package com.example.justanotherinventoryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
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
                // check if the user inputted a number for the quantity
                try {
                    quantity = Integer.parseInt(quantityInput.getText().toString());
                } catch(Exception e) {
                    isItInt = false;
                }
                // if yes, display the error message
                if (!(isItInt) || quantity < 0) {
                    errorMsg.setVisibility(View.VISIBLE);
                } else {
                    // if not, check for duplication error
                    quantity = Integer.parseInt(quantityInput.getText().toString());
                    if (!(Item.addNewItem(name, quantity))) {
                        // if yes, display the error message
                        errorMsg2.setVisibility(View.VISIBLE);
                    } else {
                        // if no, save the data in Item.class and exit
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
