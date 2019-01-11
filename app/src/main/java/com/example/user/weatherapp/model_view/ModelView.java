package com.example.user.weatherapp.model_view;

public class ModelView {

    private String city;
    private int id;
    private float temp;
    private float homidity;
    private String dat;

    public ModelView(String city, int id, float temp, float homidity, String dat) {

        this.city = city;
        this.id = id;
        this.temp = temp;
        this.homidity = homidity;
        this.dat = dat;
    }

    public String getCityForView() {
        return city;
    }

    public int getIdForView() {
        return id;
    }

    public float getTempForView() {
        return temp;
    }

    public float getHomidityForView() {
        return homidity;
    }

    public String getDatForView() {
        return dat;
    }
}
