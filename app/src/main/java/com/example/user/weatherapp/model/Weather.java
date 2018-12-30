package com.example.user.weatherapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("main")
    @Expose
    private Main main;

    public Main getMain() {
        return main;
    }

}
