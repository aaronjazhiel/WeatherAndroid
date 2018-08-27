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

        ArrayList diasSemana = new ArrayList();

        diasSemana.add("Lunes");
        diasSemana.add("Martes");
        diasSemana.add("Miercoles");
        diasSemana.add("Jueves");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");

         ArrayAdapter arrayAdapterDias = new ArrayAdapter(this,android.R.layout.simple_list_item_1,diasSemana);
          setListAdapter(arrayAdapterDias);

    }
}
