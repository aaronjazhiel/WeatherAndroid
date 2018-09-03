package mx.com.superfish.colorweather;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;

public class HourlyWeatherActivity extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


        ArrayList horyList = new ArrayList();

      for(int i = 0;i < 500; i++){
          Hour hour = new Hour();
          hour.setHora("9:00 pm");
          hour.setDescription("Party Cloudry");
          horyList.add(hour);
      }

        AdapaterHourlyWeather hourlyAdapater = new  AdapaterHourlyWeather(horyList,this);
        setListAdapter(hourlyAdapater);

    }
}
