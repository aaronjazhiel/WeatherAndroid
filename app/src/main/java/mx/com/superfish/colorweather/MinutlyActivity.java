package mx.com.superfish.colorweather;


import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class MinutlyActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly);

    ArrayList minutlyList = new ArrayList();
    for(int i = 0; i < 500 ; i++){
    Minutly minutly = new Minutly();
        minutly.setMinutlyTitle("9:00 pm");
        minutly.setMinutlyPorcentaje("0%");
        minutlyList.add(minutly);
    }
     AdapaterMinutlyWeather minutlyAdapater = new AdapaterMinutlyWeather(minutlyList, this);
     setListAdapter(minutlyAdapater);

    }

}
