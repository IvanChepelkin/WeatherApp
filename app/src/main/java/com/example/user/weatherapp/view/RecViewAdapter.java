package com.example.user.weatherapp.view;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.user.weatherapp.R;
import com.example.user.weatherapp.model_view.ModelView;
import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.RecViewHolder> {

    private List<ModelView> listWeather;
    private Typeface typeWeather;

    public RecViewAdapter(List<ModelView> listWeather, Typeface typeWeather) {
        this.listWeather = listWeather;
        this.typeWeather = typeWeather;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rec_view_data_weather, viewGroup, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder recViewHolder, int i) {
        String city = listWeather.get(i).getCityForView();
        String dat = listWeather.get(i).getDatForView();

        String humi = "Humidity: " + String.valueOf(listWeather.get(i).getHomidityForView())+ " %";
        String press = "Pressure: " + String.valueOf(Math.round((listWeather.get(i).getPress() * 100) / 133.32)) + " hPa";
        String temper = String.valueOf(Math.round(listWeather.get(i).getTempForView()));

        recViewHolder.city.setText(city);
        recViewHolder.dat.setText(dat);

        recViewHolder.weather_icon.setTypeface(typeWeather);
        recViewHolder.weather_icon.setText(listWeather.get(i).getIdForIcon());

        recViewHolder.humidity.setText(humi);
        recViewHolder.press.setText(press);
        recViewHolder.temp.setText(temper);

    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }


    class RecViewHolder extends RecyclerView.ViewHolder {

        private TextView city;
        private TextView dat;
        private TextView weather_icon;
        private TextView humidity;
        private TextView press;
        private TextView temp;

        private RecViewHolder(@NonNull View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.city);
            dat = itemView.findViewById(R.id.dat);
            weather_icon = itemView.findViewById(R.id.weather_icon);
            humidity = itemView.findViewById(R.id.humidity);
            press = itemView.findViewById(R.id.press);
            temp = itemView.findViewById(R.id.temp);

        }
    }
}
