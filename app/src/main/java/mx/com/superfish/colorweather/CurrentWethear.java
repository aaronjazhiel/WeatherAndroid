package mx.com.superfish.colorweather;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import butterknife.BindDrawable;
import butterknife.ButterKnife;

public class CurrentWethear {

    private String imagenTiempo;
    private String descripcionWeather;
    private String  gradosnWeather;
    private String  gradoUnoWeather;
    private String  gradDosWwtaher;

    public static final String CLEAR_NIGHT = "clear-night";
    public static final String CLEAR_DAY = "clear-day";
    public static final String CLOUDY = "cloudy";
    public static final String PARTLY_CLOUDY_NIGHT = "partly-cloudy-night";
    public static final String FOG = "fog";
    public static final String NA = "na";
    public static final String PARTLY_CLOUDY_DAY = "partly-cloudy-day";
    public static final String RAIN = "rain";
    public static final String SLEET = "sleet";
    public static final String SNOW = "snow";
    public static final String SUNNY = "sunny";
    public static final String WIND = "wind";


    @BindDrawable(R.drawable.clear_night) Drawable clearNight;
    @BindDrawable(R.drawable.clear_day) Drawable clearDay;
    @BindDrawable(R.drawable.cloudy) Drawable cloudy;
    @BindDrawable(R.drawable.cloudy_night) Drawable cloudyNight;
    @BindDrawable(R.drawable.fog) Drawable fog;
    @BindDrawable(R.drawable.na) Drawable na;
    @BindDrawable(R.drawable.partly_cloudy) Drawable partlyCloudy;
    @BindDrawable(R.drawable.rain) Drawable rain;
    @BindDrawable(R.drawable.sleet) Drawable sleet;
    @BindDrawable(R.drawable.snow) Drawable snow;
    @BindDrawable(R.drawable.sunny) Drawable sunny;
    @BindDrawable(R.drawable.wind) Drawable wind;


    public CurrentWethear(Activity activity) {
        ButterKnife.bind(this,activity);

    }

    public String getImagenTiempo() {
        return imagenTiempo;
    }

    public void setImagenTiempo(String imagenTiempo) {
        this.imagenTiempo = imagenTiempo;
    }

    public String getDescripcionWeather() {
        return descripcionWeather;
    }

    public void setDescripcionWeather(String descripcionWeather) {
        this.descripcionWeather = descripcionWeather;
    }

    public String getGradosnWeather() {
        return gradosnWeather;
    }

    public void setGradosnWeather(String gradosnWeather) {
        this.gradosnWeather = gradosnWeather;
    }

    public String getGradoUnoWeather() {
        return gradoUnoWeather;
    }

    public void setGradoUnoWeather(String gradoUnoWeather) {
        this.gradoUnoWeather = gradoUnoWeather;
    }

    public String getGradDosWwtaher() {
        return gradDosWwtaher;
    }

    public void setGradDosWwtaher(String gradDosWwtaher) {
        this.gradDosWwtaher = gradDosWwtaher;
    }

    public Drawable getIconDrawableResource(){

        switch (imagenTiempo) {

            case CLEAR_NIGHT:
                return clearNight;
            case CLEAR_DAY:
                return clearDay;
            case CLOUDY:
                return cloudy;
            case PARTLY_CLOUDY_NIGHT:
                return cloudyNight;
            case FOG:
                return fog;
            case NA:
                return na;
            case PARTLY_CLOUDY_DAY:
                return partlyCloudy;
            case RAIN:
                return rain;
            case SLEET:
                return sleet;
            case SNOW:
                return snow;
            case SUNNY:
                return sunny;
            case WIND:
                return wind;
            default:
                return na;
        }

    }
}
