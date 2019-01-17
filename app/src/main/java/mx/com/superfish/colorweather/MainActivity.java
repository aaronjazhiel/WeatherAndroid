package mx.com.superfish.colorweather;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    public static final String DATA = "data";
    public static final String SUMMARY = "summary";
    public static final String ICON = "icon";
    public static final String TEMPERATURE = "temperature";
    public static final String TEMPERATURE_MAX = "temperatureMax";
    public static final String TEMPERATURE_MIN = "temperatureMin";
    public static final String PRECIP_PROBABILITY = "precipProbability";

    public static final String CURRENTLY = "currently";
    public static final String DAILY = "daily";
    public static final String HOURLY = "hourly";
    public static final String TIME = "time";
    public static final String H = "H: ";
    public static final String L = "L: ";
    public static final int INDEX = 0;
    public static final String HH_MM = "HH:mm";
    public static final int INT = 1000;
    public static final String MINUTELY = "minutely";


    @BindView(R.id.imageView)
    ImageView imagenTiempo;

    @BindView(R.id.tiempo)
    TextView descripcionWeather;

    @BindView(R.id.grados)
    TextView gradosnWeather;

    @BindView(R.id.grado_uno)
    TextView gradoUnoWeather;

    @BindView(R.id.grado_dos)
    TextView gradDosWwtaher;

    @BindView(R.id.daily)
    TextView dailyWeather;
    @BindView(R.id.hora)
    TextView horalyWeather;
    @BindView(R.id.Minutly)
    TextView minulyWeather;

    @BindDrawable(R.drawable.clear_night)
    Drawable clearDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

         RequestQueue queue = Volley.newRequestQueue(this);
         String url ="https://api.darksky.net/forecast/4f0c0ebef23640b55627ee2f95d57261/37.8267,-122.4233?units=si";




         StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {

                            //CurrentWethear currentWethear=getCurrentWetaherFromJson(response);
                           // ArrayList<Day> dailyList  = getDaylyWeather(response);
                          //  ArrayList<Hour> hourlyList = getHourlyWeather(response);
                            ArrayList<Minutly> minutlyList = getMinutlyWeather(response);

                            for(int i=0 ;i<minutlyList.size();i++){

                                Minutly minutly=minutlyList.get(i);

                                System.out.println("aaaa"+minutly.getMinutlyTitle());
                                System.out.println(minutly.getMinutlyPorcentaje());

                            }



                            /*imagenTiempo.setImageDrawable(currentWethear.getIconDrawableResource());
                            descripcionWeather.setText(currentWethear.getDescripcionWeather());
                            gradosnWeather.setText(currentWethear.getTemperature());
                            gradoUnoWeather.setText(currentWethear.getGradoUnoWeather());
                            gradDosWwtaher.setText(currentWethear.getGradDosWwtaher());*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // mTextView.setText("That didn't work!");
                System.out.println("Esto es un error");
            }
        });
         queue.add(stringRequest);


        dailyWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Daly");
                Intent dailyitem = new Intent(MainActivity.this,DalyWeatherActivity.class);
                startActivity(dailyitem);
            }
        });

        horalyWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyitem = new Intent(MainActivity.this,HourlyWeatherActivity.class);
                startActivity(dailyitem);
                System.out.println("horaaa");
            }
        });
        minulyWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailyitem = new Intent(MainActivity.this,MinutlyActivity.class);
                startActivity(dailyitem);
                System.out.println("Minuto");
            }
        });
    }

    private CurrentWethear getCurrentWetaherFromJson(String json) throws JSONException{
         JSONObject jsonObject = new JSONObject(json);
         CurrentWethear currentWethear = new CurrentWethear(MainActivity.this);
         JSONObject  currentyWeather =  jsonObject.getJSONObject(CURRENTLY);
         String sumary = currentyWeather.getString(SUMMARY);
         String icon = currentyWeather.getString(ICON);
         String temperature = Math.round(currentyWeather.getDouble(TEMPERATURE)) + " ";
         JSONObject  jsonWithDayWeather = jsonObject.getJSONObject(DAILY);
         JSONArray  jsonWithDataWeather = jsonWithDayWeather.getJSONArray(DATA);
         JSONObject jsoTodayWeather = jsonWithDataWeather.getJSONObject(INDEX);
         String maxTemperature = H +Math.round(jsoTodayWeather.getDouble(TEMPERATURE_MAX))+ "";
         String minTemperature = L +Math.round(jsoTodayWeather.getDouble(TEMPERATURE_MIN))+ "";

         currentWethear.setDescripcionWeather(sumary);
         currentWethear.setImagenTiempo(icon);
         currentWethear.setTemperature(temperature);
         currentWethear.setGradoUnoWeather(maxTemperature);
         currentWethear.setGradDosWwtaher(minTemperature);
        return currentWethear;
    }

    private ArrayList<Day> getDaylyWeather(String json)  throws JSONException{

        DateFormat date = new SimpleDateFormat("EEEE");

        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonWithDayWeather = jsonObject.getJSONObject(DAILY);
        JSONArray  jsonWithDataWeather = jsonWithDayWeather.getJSONArray(DATA);
        ArrayList<Day> dayList = new ArrayList<Day>();

        for(int i=0 ;i< jsonWithDataWeather.length();i++){
           JSONObject dalyWeData = jsonWithDataWeather.getJSONObject(i);
           String rainProbability =  dalyWeData.getString(PRECIP_PROBABILITY);
           String descriptionDayli = dalyWeData.getString(SUMMARY);
           String fecha =  date.format(dalyWeData.getDouble(TIME)*1000);
           Day dia= new Day();
           dia.setTitulo(descriptionDayli);
           dia.setDescription(fecha);
           dia.setProcentaje(rainProbability);
           dayList.add(dia);
        }
        return dayList ;
    }


    private ArrayList<Hour> getHourlyWeather(String json)  throws JSONException{

        DateFormat date = new SimpleDateFormat(HH_MM);
        date.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));


        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonWitHourWeather = jsonObject.getJSONObject(HOURLY);
        JSONArray  jsonWithDataWeather = jsonWitHourWeather.getJSONArray(DATA);

        ArrayList<Hour> hourlyList = new ArrayList<Hour>();

        for(int i=0 ;i< jsonWithDataWeather.length();i++){
            JSONObject dalyWeData = jsonWithDataWeather.getJSONObject(i);
            String fecha =  date.format(dalyWeData.getDouble(TIME)* INT);
            String descriptionHorlyli = dalyWeData.getString(SUMMARY);
            Hour hora= new Hour();
            hora.setHora(fecha);
            hora.setDescription(descriptionHorlyli);
            hourlyList.add(hora);
        }
        return hourlyList;
    }


    private ArrayList<Minutly> getMinutlyWeather(String json)  throws JSONException{

        System.out.println("*****************************");

        DateFormat date = new SimpleDateFormat(HH_MM);
        date.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));

        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonWitHourWeather = jsonObject.getJSONObject(MINUTELY);
        JSONArray  jsonWithDataWeather = jsonWitHourWeather.getJSONArray(DATA);

        ArrayList<Minutly> minutlyList = new ArrayList<Minutly>();

        for(int i=0 ;i< jsonWithDataWeather.length();i++){
            JSONObject dalyWeData = jsonWithDataWeather.getJSONObject(i);
            String fecha =  date.format(dalyWeData.getDouble(TIME)* INT);
            String rainProbability =  dalyWeData.getString(PRECIP_PROBABILITY);
            Minutly minutly= new Minutly();
            minutly.setMinutlyTitle(fecha);
            minutly.setMinutlyPorcentaje(rainProbability);
            minutlyList.add(minutly);
        }
        return minutlyList;
    }

}
