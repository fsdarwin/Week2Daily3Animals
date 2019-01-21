package com.example.week2daily3animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Act3Choose extends AppCompatActivity {

    Animal animal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3_choose);

        String[] animalNames = {"Antelope", "Tiger", "Skink", "Parrot", "Tuna", "Human", "Frog"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, animalNames);

        final ListView listView = findViewById(R.id.lvListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) listView.getItemAtPosition(position);
                switch (name) {
                    case "Antelope":
                        animal = new Animal("Antelope", "Mammal", "Brraa", "https://easyscienceforkids.com/wp-content/uploads/2013/04/red-Antelope.jpg");
                        break;
                    case "Tiger":
                        animal = new Animal("Tiger", "Mammal", "Roar", "https://img.purch.com/w/660/aHR0cDovL3d3dy5saXZlc2NpZW5jZS5jb20vaW1hZ2VzL2kvMDAwLzEwMC8zNDkvb3JpZ2luYWwvc2liZXJpYW4tdGlnZXIuanBn");
                        break;
                    case "Skink":
                        animal = new Animal("Skink", "Lizard", "NONE", "https://cdn.britannica.com/s:300x300/96/7696-004-30A9E9CA.jpg");
                        break;
                    case "Parrot":
                        animal = new Animal("Parrot", "Bird", "ANY", "https://www.parakeethome.com/wp-content/uploads/2018/05/Parrot.jpg");
                        break;
                    case "Tuna":
                        animal = new Animal("Tuna", "Fish", "Bloop", "https://www.anglersjournal.com/.image/ar_16:9%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cg_faces:center%2Cq_auto:good%2Cw_768/MTQ2OTAxMTA0NjYwNzE5NDE0/yellowfin-tuna.jpg");
                        break;
                    case "Human":
                        animal = new Animal("Human", "Mammal", "Er-doy", "https://cdn2.omidoo.com/sites/default/files/imagecache/full_width/images/bydate/aug_1_2012_-_1023am/shutterstock_46488256.jpg");
                        break;
                    case "Frog":
                        animal = new Animal("Frog", "Amphibian", "Ri-bit", "https://www.abc.net.au/cm/rimage/9395538-16x9-xlarge.jpg?v=2");
                        break;
                }
                finish();
            }
        });
    }@Override
    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("animal", animal);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }
}
