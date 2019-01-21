package com.example.week2daily3animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RVAdapter rvAdapter;
    ListView lstView;
    DBHelper sqldbHelper = new DBHelper(this);//Instantiate the database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String TAG = "FRANK: ";

        //INSERT animals and log them
        Animal animalA = new Animal("Antelope", "Mammal", "Brraa", "https://easyscienceforkids.com/wp-content/uploads/2013/04/red-Antelope.jpg");
        sqldbHelper.insertAnimal(animalA);
        Log.d(TAG, "INSERT: " + animalA.getName() + ", " + animalA.getType() + ", " + animalA.getSound());
        Animal animalB = new Animal("Tiger", "Mammal", "Roar", "https://img.purch.com/w/660/aHR0cDovL3d3dy5saXZlc2NpZW5jZS5jb20vaW1hZ2VzL2kvMDAwLzEwMC8zNDkvb3JpZ2luYWwvc2liZXJpYW4tdGlnZXIuanBn");
        sqldbHelper.insertAnimal(animalB);
        Log.d(TAG, "INSERT: " + animalB);
        Animal animalC = new Animal("Skink", "Lizard", "NONE", "https://cdn.britannica.com/s:300x300/96/7696-004-30A9E9CA.jpg");
        sqldbHelper.insertAnimal(animalC);
        Log.d(TAG, "INSERT: " + animalC);
        Animal animalD = new Animal("Parrot", "Bird", "ANY", "https://www.parakeethome.com/wp-content/uploads/2018/05/Parrot.jpg");
        sqldbHelper.insertAnimal(animalD);
        Log.d(TAG, "INSERT: " + animalD);
        Animal animalE = new Animal("Tuna", "Fish", "Bloop", "https://www.anglersjournal.com/.image/ar_16:9%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cg_faces:center%2Cq_auto:good%2Cw_768/MTQ2OTAxMTA0NjYwNzE5NDE0/yellowfin-tuna.jpg");
        sqldbHelper.insertAnimal(animalE);
        Log.d(TAG, "INSERT: " + animalE);
        Animal animalF = new Animal("Human", "Mammal", "Er-doy", "https://cdn2.omidoo.com/sites/default/files/imagecache/full_width/images/bydate/aug_1_2012_-_1023am/shutterstock_46488256.jpg");
        sqldbHelper.insertAnimal(animalF);
        Log.d(TAG, "INSERT: " + animalF);
        Animal animalG = new Animal("Frog", "Amphibian", "Ri-bit", "https://www.abc.net.au/cm/rimage/9395538-16x9-xlarge.jpg?v=2");
        sqldbHelper.insertAnimal(animalG);
        Log.d(TAG, "INSERT: " + animalG);

        Intent intent = new Intent(this, Act2Display.class);
        startActivity(intent);
    }
}