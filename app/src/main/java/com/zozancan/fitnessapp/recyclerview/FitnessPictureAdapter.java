package com.zozancan.fitnessapp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zozancan.fitnessapp.FitnessMoves;
import com.zozancan.fitnessapp.R;

import java.util.ArrayList;

public class FitnessPictureAdapter extends RecyclerView.Adapter<FitnessPicturesViewHolder> implements View.OnClickListener {

    private ArrayList<FitnessMoves> fitnessMoves;
    private LayoutInflater layoutInflater;
    private AppCompatActivity appCompatActivity;
    private MyListener myListener;

    public FitnessPictureAdapter(AppCompatActivity appCompatActivity, MyListener myListener) {
        this.appCompatActivity = appCompatActivity;
        this.myListener = myListener;
        layoutInflater = appCompatActivity.getLayoutInflater();
        fitnessMoves = new ArrayList<>();
    }

    public ArrayList<FitnessMoves> getFitnessMoves() {
        return fitnessMoves;
    }

    @NonNull
    @Override
    public FitnessPicturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listView = layoutInflater.inflate(R.layout.recyclerview_pictures_list,parent,false);
        listView.setOnClickListener(this);

        return new FitnessPicturesViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessPicturesViewHolder holder, int position) {
        holder.getMoves(appCompatActivity, fitnessMoves.get(position));
    }

    @Override
    public int getItemCount() {
        return fitnessMoves.size();
    }

    @Override
    public void onClick(View v) {

        if (v.getTag() instanceof FitnessMoves) {
            FitnessMoves fitnessMoves = (FitnessMoves) v.getTag();
            myListener.MyListener(fitnessMoves);

        }


    }

    public interface MyListener {

        public void MyListener(FitnessMoves fitnessMoves);

    }
}
