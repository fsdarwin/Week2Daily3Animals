package com.example.week2daily3animals;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RVHolder extends RecyclerView.ViewHolder {

    TextView tvId;
    TextView tvName;
    TextView tvType;
    TextView tvSound;
    TextView tvPop;
    ImageView imgImage;

    public RVHolder(View itemView) {
        super(itemView);

        this.tvId= itemView.findViewById(R.id.tvId);
        this.tvName= itemView.findViewById(R.id.tvName);
        this.tvType= itemView.findViewById(R.id.tvType);
        this.tvSound= itemView.findViewById(R.id.tvSound);
        this.tvPop= itemView.findViewById(R.id.tvPop);
        this.imgImage= itemView.findViewById(R.id.imgImage);
    }

}