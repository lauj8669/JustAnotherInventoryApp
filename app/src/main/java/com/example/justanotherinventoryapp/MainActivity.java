package com.example.justanotherinventoryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // _____________________________________instance  variables_____________________________________
    // general
    private FloatingActionButton add;
    private FloatingActionButton delete;
    private Button sortAlphabet;
    private RecyclerView recyclerView;
    String[] names;
    String[] types;
    int[] quants;
    static boolean firstTime = true;

    // for storing data
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        add = findViewById(R.id.fab);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), addNewItem.class));
                finish();
            }
        });
        delete = findViewById(R.id.deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item.listOfItems.clear();
                finish();
                startActivity(getIntent());
            }
        });
        sortAlphabet = findViewById(R.id.sortAlphabet);
        sortAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item.sortAlphabet();
                finish();
                startActivity(getIntent());
            }
        });

        if (firstTime) {
            loadData();
            firstTime = false;
        }

        recyclerView = findViewById(R.id.recyclerView);
        names = Item.getItemNames();
        types = Item.getItemTypes();
        quants = Item.getItemQuantities();
        myAdaptor adaptor = new myAdaptor(this, names, types, quants);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        saveData();
    }

    // ________________________________methods regarding saving data________________________________
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json  = gson.toJson(Item.listOfItems);
        editor.putString("Item List", json);
        editor.commit();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Item List", null);
        Type type = new TypeToken<List<Item.EachItem>>() {}.getType();
        if (gson.fromJson(json, type) == null) {
            return;
        } else {
            Item.listOfItems = gson.fromJson(json, type);
        }
    }

    // _______________________________________unused  methods_______________________________________
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
