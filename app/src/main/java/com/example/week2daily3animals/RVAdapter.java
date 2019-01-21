package com.example.week2daily3animals;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class RVAdapter extends RecyclerView.Adapter<RVHolder> {

    Context context;
    SQLiteDatabase sqldb;
    DBHelper helper;
    ArrayList<DBAnimal> dbanimalArrayList;
    public static final String TAG = "FRANK: ";


    public RVAdapter(ArrayList<DBAnimal> dbanimalArrayList, Context context) {
        this.dbanimalArrayList = dbanimalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder viewHolder, int position) {
        DBAnimal dbAnimal = dbanimalArrayList.get(position);

        if (dbAnimal != null) {
            int id = dbAnimal.getId();
            String name = "Name: " + dbAnimal.getAnimal().getName();
            String type = "Type: " + dbAnimal.getAnimal().getType();
            String sound = "Sound: " + dbAnimal.getAnimal().getSound();
            String pop = "Pop: " + dbAnimal.getAnimal().getPop();
            String image = dbAnimal.getAnimal().getImage();

            viewHolder.tvId.setText(String.valueOf(id));
            viewHolder.tvName.setText(name);
            viewHolder.tvType.setText(type);
            viewHolder.tvSound.setText(sound);
            viewHolder.tvPop.setText(pop);
            Picasso.get()
                    .load(image)
                    .into(viewHolder.imgImage);
            Log.d(TAG, "onBindViewHolder: " + name + ", " + image);
        }

    }



    @Override
    public int getItemCount() {
        return dbanimalArrayList != null ? dbanimalArrayList.size() : 0;
    }

    public void deletePosition(int pos) {
        //GET ID
        DBAnimal dbAnimal = dbanimalArrayList.get(pos);
        int id = dbAnimal.getId();

        //DELETE FROM DB
        DBHelper sqldb = new DBHelper(context);
        if (sqldb.deleteAnimal(id)) {
            dbanimalArrayList.remove(pos);
        } else {
            Toast.makeText(context, "Unable To Delete", Toast.LENGTH_SHORT).show();
        }
        this.notifyItemRemoved(pos);

    }
}
