package com.example.user.weatherapp.model_view;

public class ModelView {

    private String city;
    private String dat;
    private int id;
    private float humidity;
    private float press;
    private float temp;

    public ModelView(String city, String dat, int id, float humidity, float press, float temp) {

        this.city = city;
        this.dat = dat;
        this.id = id;
        this.humidity = humidity;
        this.press = press;
        this.temp = temp;

    }

    public String getCityForView() {
        return city;
    }

    public String getDatForView() {
        return dat;
    }

    public int getIdForIcon() {
        return id;
    }

    public float getHomidityForView() {
        return humidity;
    }

    public float getPress() {
        return press;
    }

    public float getTempForView() {
        return temp;
    }

}
