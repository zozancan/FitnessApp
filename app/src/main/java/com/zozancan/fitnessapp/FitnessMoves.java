package com.zozancan.fitnessapp;

import android.os.Parcel;
import android.os.Parcelable;

public class FitnessMoves implements Parcelable {


    private String fitnessName;
    private String fitnessPictures;
    private String fitnessDescriptions;
    private int fitnessCalories;

    public FitnessMoves(String fitnessName, String fitnessPictures, String fitnessDescriptions, int fitnessCalories) {
        this.fitnessName = fitnessName;
        this.fitnessPictures = fitnessPictures;
        this.fitnessDescriptions = fitnessDescriptions;
        this.fitnessCalories = fitnessCalories;
    }

    public String getFitnessName() {
        return fitnessName;
    }

    public String getFitnessPictures() {
        return fitnessPictures;
    }

    public String getFitnessDescriptions() {
        return fitnessDescriptions;
    }

    public int getFitnessCalories() {
        return fitnessCalories;
    }


    protected FitnessMoves(Parcel in) {

        fitnessName = in.readString();
        fitnessPictures = in.readString();
        fitnessDescriptions = in.readString();
        fitnessCalories = in.readInt();
    }

    public static final Creator<FitnessMoves> CREATOR = new Creator<FitnessMoves>() {
        @Override
        public FitnessMoves createFromParcel(Parcel in) {
            return new FitnessMoves(in);
        }

        @Override
        public FitnessMoves[] newArray(int size) {
            return new FitnessMoves[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(fitnessName);
        dest.writeString(fitnessPictures);
        dest.writeString(fitnessDescriptions);
        dest.writeInt(fitnessCalories);
    }
}
