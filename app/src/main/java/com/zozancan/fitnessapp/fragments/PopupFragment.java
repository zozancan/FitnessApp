package com.zozancan.fitnessapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.zozancan.fitnessapp.FitnessMoves;
import com.zozancan.fitnessapp.R;

public class PopupFragment extends Fragment {

    TextView nameText;
    TextView descriptionText;
    TextView calorieText;
    ImageView imageView;
    ProgressBar progressBar;
    private FitnessMoves fitnessMoves;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_popup, container, false);
        nameText = rootView.findViewById(R.id.fragment_popup_name_textview);
        descriptionText = rootView.findViewById(R.id.fragment_popup_description_textview);
        calorieText = rootView.findViewById(R.id.fragment_popup_calorie_textview);
        imageView = rootView.findViewById(R.id.fragment_popup_imageview);
        progressBar = rootView.findViewById(R.id.fragment_popup_progressbar);

        nameText.setText(fitnessMoves.getFitnessName());
        descriptionText.setText(fitnessMoves.getFitnessDescriptions());
        calorieText.setText("" + fitnessMoves.getFitnessCalories());

        Picasso.get().load(fitnessMoves.getFitnessPictures()).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });

        return rootView;
    }

    public static PopupFragment newInstance() {
        return new PopupFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fitnessMoves = getActivity().getIntent().getParcelableExtra("INFO");
    }
}
