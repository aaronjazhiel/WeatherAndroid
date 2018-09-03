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

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

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
      //   String url ="https://api.darksky.net/forecast/4f0c0ebef23640b55627ee2f95d57261/19.4284700,-99.1276600?units=si";

        String url ="http://www.superfish.com.mx/v1/citas";



         StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            CurrentWethear currentWethear=getCurrentWetaherFromJson(response);
                           // imagenTiempo.setImageDrawable(currentWethear.getIconDrawableResource());
                            //descripcionWeather.setText(currentWethear.getDescripcionWeather());
                            //gradosnWeather.setText(currentWethear.getTemperature());
                            //gradoUnoWeather.setText(currentWethear.getGradoUnoWeather());
                            //gradDosWwtaher.setText(currentWethear.getGradDosWwtaher());
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
        // JSONObject jsonObject = new JSONObject(json);



        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String  name = object.getString("firstname")+" "+object.getString("lastname");
            String  user_mail = object.getString("user_email");
            String  horario = object.getString("horario");
            String  fecha = object.getString("fecha");

            System.out.println("------------------------------");
            System.out.println("Nombre: "+ name);
            System.out.println("Correo: "+ user_mail);
            System.out.println("horario: "+ horario);
            System.out.println("fecha: "+ fecha);
            System.out.println("-------------------------------");

        }




        CurrentWethear currentWethear = new CurrentWethear(MainActivity.this);
         /*JSONObject  currentyWeather =  jsonObject.getJSONObject("currently");
         String sumary = currentyWeather.getString("summary");
         String icon = currentyWeather.getString("icon");
         String temperature = Math.round(currentyWeather.getDouble("temperature")) + " ";
         JSONObject  jsonWithDayWeather = jsonObject.getJSONObject("daily");
         JSONArray  jsonWithDataWeather = jsonWithDayWeather.getJSONArray("data");
         JSONObject jsoTodayWeather = jsonWithDataWeather.getJSONObject(0);
         String maxTemperature ="H: "+ Math.round(jsoTodayWeather.getDouble("temperatureMax"))+ "";
         String minTemperature ="L: "+Math.round(jsoTodayWeather.getDouble("temperatureMin"))+ "";
         CurrentWethear currentWethear = new CurrentWethear(MainActivity.this);
         currentWethear.setDescripcionWeather(sumary);
         currentWethear.setImagenTiempo(icon);
         currentWethear.setTemperature(temperature);
         currentWethear.setGradoUnoWeather(maxTemperature);
         currentWethear.setGradDosWwtaher(minTemperature);*/
        return currentWethear;
    }

    private   void getDayliWeather(){


    }


}
