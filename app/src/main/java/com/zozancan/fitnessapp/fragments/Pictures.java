package com.zozancan.fitnessapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zozancan.fitnessapp.FitnessMoves;
import com.zozancan.fitnessapp.PopupActivity;
import com.zozancan.fitnessapp.R;
import com.zozancan.fitnessapp.recyclerview.FitnessPictureAdapter;

import java.util.ArrayList;

public class Pictures extends Fragment implements FitnessPictureAdapter.MyListener {

    private FitnessPictureAdapter fitnessPictureAdapter;
    private RecyclerView recyclerView;
    private ArrayList<FitnessMoves> fitnessMoves;

    public static Pictures newInstance() {
        return new Pictures();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pictures, container, false);

        fitnessPictureAdapter = new FitnessPictureAdapter((AppCompatActivity) getActivity(), this);
        fitnessMoves = fitnessPictureAdapter.getFitnessMoves();

        recyclerView = rootView.findViewById(R.id.pictures_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        if (isAdded()) {
            recyclerView.setAdapter(fitnessPictureAdapter);
        }

        getFitnessMoves(fitnessMoves);

        return rootView;
    }

    private ArrayList<FitnessMoves> getFitnessMoves(ArrayList<FitnessMoves> fitnessMoves) {

        for (int i = 0; i < 16; i++) {
            String url = "http://www.atilsamancioglu.com/wp-content/uploads/2018/06/fitness" + i + ".jpg";
            Log.e("PicturesJava", url);
            fitnessMoves.add(new FitnessMoves("Fitness Move Name" + i,
                    url,
                    "Fitness Move Description", 100));

        }


        return fitnessMoves;
    }


    @Override
    public void MyListener(FitnessMoves fitnessMoves) {

        Intent intent = PopupActivity.newIntent(getActivity(), fitnessMoves);
        startActivity(intent);

    }
}
