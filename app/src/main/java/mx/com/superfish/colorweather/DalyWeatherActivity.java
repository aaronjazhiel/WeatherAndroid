package mx.com.superfish.colorweather;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DalyWeatherActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daly_weather);

        ArrayList listDay = new ArrayList();


       for(int i =0 ;i <500 ;i++) {
           Day day = new Day();
           day.setTitulo("Thiurday");
           day.setDescription("Partly Cloudly in the morning");
           day.setProcentaje("porcentaje");
           listDay.add(day);

       }
        AdapaterDailyWeather dailyAdapater = new    AdapaterDailyWeather(listDay,this);
        setListAdapter(dailyAdapater);
    }
}
