package com.example.week2daily3animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Act2Display extends AppCompatActivity {
    RecyclerView recyclerView;
    RVAdapter rvAdapter;
    ListView lstView;
    public static final String TAG = "FRANK: ";
    DBHelper sqldbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2_display);

        recyclerView = findViewById(R.id.rvMainRecyclerView);
        RVAdapter rvAdapter = new RVAdapter(listOfAnimals(), this);
        recyclerView.setAdapter(rvAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ItemTouchHelper.Callback callback = new SwipeHelper(rvAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);


    }

    private ArrayList<DBAnimal> listOfAnimals() {
        ArrayList<DBAnimal> animalArrayList;

        animalArrayList = sqldbHelper.selectAllAnimals();

        return animalArrayList;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, Act3Choose.class);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            if (data.hasExtra("animal")) {
                Animal animal = data.getParcelableExtra("animal");
                sqldbHelper.insertAnimal(animal);
                Act2Display.super.recreate();
            }
        }
    }
}
