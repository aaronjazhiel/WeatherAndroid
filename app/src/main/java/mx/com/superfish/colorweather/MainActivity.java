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

        CurrentWethear currentWethear = new CurrentWethear(MainActivity.this);


        currentWethear.setImagenTiempo("sunny");
        currentWethear.setDescripcionWeather("Beltran como estas");
        currentWethear.setGradosnWeather("60");
        currentWethear.setGradoUnoWeather("H:39°");
        currentWethear.setGradDosWwtaher("L:23°");

       imagenTiempo.setImageDrawable(currentWethear.getIconDrawableResource());
        descripcionWeather.setText(currentWethear.getDescripcionWeather());
        gradosnWeather.setText(currentWethear.getGradosnWeather());
        gradoUnoWeather.setText(currentWethear.getGradoUnoWeather());
        gradDosWwtaher.setText(currentWethear.getGradDosWwtaher());

         RequestQueue queue = Volley.newRequestQueue(this);
         String url ="https://api.darksky.net/forecast/4f0c0ebef23640b55627ee2f95d57261/37.8267,-122.4233";
         StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //try {

                        System.out.print("aaaaaaaaaaaaaaaaaaaaaaaa"+response.substring(0,500));

                          //  getCurrentWetaherFromJson(response);
                       // } catch (JSONException e) {
                         //   e.printStackTrace();
                        //}
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
        //JSONObject  currentyWeather =  jsonObject.getJSONObject("currently");
        //JSONObject dalyWeather = jsonObject.getJSONObject("daily");
        //JSONArray jsonData  = jsonObject.getJSONArray("data");
        //String sumary = currentyWeather.getString("summaryyy");
        //String icon = currentyWeather.getString("icon");
        //String temperature = currentyWeather.getDouble("temperature") + " ";


       System.out.println("Probando la petición "+ json);

        return null;
    }
}
