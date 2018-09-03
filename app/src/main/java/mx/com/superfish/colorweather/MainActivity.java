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

import java.util.ArrayList;

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
         String url ="https://api.darksky.net/forecast/4f0c0ebef23640b55627ee2f95d57261/19.4284700,-99.1276600?units=si";

         StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            CurrentWethear currentWethear=getCurrentWetaherFromJson(response);
                            imagenTiempo.setImageDrawable(currentWethear.getIconDrawableResource());
                            descripcionWeather.setText(currentWethear.getDescripcionWeather());
                            gradosnWeather.setText(currentWethear.getTemperature());
                            gradoUnoWeather.setText(currentWethear.getGradoUnoWeather());
                            gradDosWwtaher.setText(currentWethear.getGradDosWwtaher());
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
         JSONObject  currentyWeather =  jsonObject.getJSONObject("currently");
         String sumary = currentyWeather.getString("summary");
         String icon = currentyWeather.getString("icon");
         String temperature = Math.round(currentyWeather.getDouble("temperature")) + " ";
         JSONObject  jsonWithDayWeather = jsonObject.getJSONObject("daily");
         JSONArray  jsonWithDataWeather = jsonWithDayWeather.getJSONArray("data");
         JSONObject jsoTodayWeather = jsonWithDataWeather.getJSONObject(0);
         String maxTemperature ="H: "+ Math.round(jsoTodayWeather.getDouble("temperatureMax"))+ "";
         String minTemperature ="L: "+Math.round(jsoTodayWeather.getDouble("temperatureMin"))+ "";
         currentWethear.setDescripcionWeather(sumary);
         currentWethear.setImagenTiempo(icon);
         currentWethear.setTemperature(temperature);
         currentWethear.setGradoUnoWeather(maxTemperature);
         currentWethear.setGradDosWwtaher(minTemperature);
        return currentWethear;
    }

    private   void getDayliWeather(){


    }

    private ArrayList<ClienteSuperFish> getClienteSuperFish(String json)throws JSONException{
        //String url ="http://www.superfish.com.mx/v1/citas";
        JSONArray jsonArray = new JSONArray(json); //Obtienes el payLoad de JSON
        ArrayList clientesDataList = new ArrayList(); //Generas el ArrayList para cachar los datos del Objeto
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            ClienteSuperFish clienteData = new ClienteSuperFish();
            clienteData.setNombre(object.getString("firstname")+" "+object.getString("lastname"));
            clienteData.setCorreo(object.getString("user_email"));
            clienteData.setFecha(object.getString("fecha"));
            clienteData.setHorario(object.getString("horario"));
            clientesDataList.add(clienteData);
        }
        return clientesDataList;
    }
}
