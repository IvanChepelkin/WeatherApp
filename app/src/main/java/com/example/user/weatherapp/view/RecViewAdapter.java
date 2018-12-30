package com.example.user.weatherapp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.weatherapp.R;
import com.example.user.weatherapp.model.Main;
import com.example.user.weatherapp.model.Weather;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.RecViewHolder> {
    private Weather weather;

    public RecViewAdapter(Weather weather) {
        this.weather = weather;
    }


    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rec_view_data_weather, viewGroup, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder recViewHolder, int i) {
        String temper = String.valueOf(weather.getMain().getTemp());
        String press = String.valueOf(weather.getMain().getPressure());
        String humi = String.valueOf(weather.getMain().getHumidity());
        String tempMa = String.valueOf(weather.getMain().getTempMax());
        String tempMi = String.valueOf(weather.getMain().getTempMin());

        recViewHolder.temp.setText(temper);
        recViewHolder.pressure.setText(press);
        recViewHolder.humidity.setText(humi);
        recViewHolder.tempMax.setText(tempMa);
        recViewHolder.tempMin.setText(tempMi);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class RecViewHolder extends RecyclerView.ViewHolder {
        private TextView temp;
        private TextView pressure;
        private TextView humidity;
        private TextView tempMax;
        private TextView tempMin;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            temp = itemView.findViewById(R.id.temp);
            pressure = itemView.findViewById(R.id.pressure);
            humidity = itemView.findViewById(R.id.humidity);
            tempMax = itemView.findViewById(R.id.tempMax);
            tempMin = itemView.findViewById(R.id.tempMin);
        }
    }
}
