package com.zozancan.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.zozancan.fitnessapp.fragments.PopupFragment;

public class PopupActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.popup_activity_framelayout);

        if (fragment == null) {
            fragment = PopupFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.popup_activity_framelayout, fragment).commit();
        }
    }

    public static Intent newIntent(Context context, FitnessMoves fitnessMoves) {
        Intent intent = new Intent(context, PopupActivity.class);
        intent.putExtra("INFO" , fitnessMoves);
        return intent;
    }
}
