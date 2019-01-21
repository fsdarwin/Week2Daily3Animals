package com.example.week2daily3animals;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SwipeHelper extends ItemTouchHelper.SimpleCallback {

    RVAdapter adapter;

    public SwipeHelper(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public SwipeHelper( RVAdapter adapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN,ItemTouchHelper.LEFT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.deletePosition(viewHolder.getAdapterPosition());
    }
}