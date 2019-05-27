package com.zozancan.fitnessapp.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.zozancan.fitnessapp.FitnessMoves;
import com.zozancan.fitnessapp.R;


public class FitnessPicturesViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    ProgressBar progressBar;

    public FitnessPicturesViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.recyclerview_pictures_list_imageview);
        progressBar = itemView.findViewById(R.id.recyclerview_pictures_list_progressbar);
    }

    public void getMoves(Context context, FitnessMoves fitnessMoves) {

        itemView.setTag(fitnessMoves);

        Picasso.get().load(fitnessMoves.getFitnessPictures()).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}
