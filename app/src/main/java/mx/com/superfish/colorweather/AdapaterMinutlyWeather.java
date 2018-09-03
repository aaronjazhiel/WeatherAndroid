package mx.com.superfish.colorweather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapaterMinutlyWeather extends BaseAdapter{


    public static  final String TAG = AdapaterMinutlyWeather.class.getSimpleName();

    ArrayList minutlyList = new ArrayList();
    Context contexto;

    public AdapaterMinutlyWeather(ArrayList minutlyList, Context contexto) {
        this.minutlyList = minutlyList;
        this.contexto = contexto;
    }
    @Override
    public int getCount() { return minutlyList.size();}

    @Override
    public Object getItem(int position) {
        return minutlyList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        Minutly minutly = (Minutly) minutlyList.get(position);

        if(view == null) {
            view = LayoutInflater.from(contexto).inflate(R.layout.minutly_weaher_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.minutlyTitle =(TextView) view.findViewById(R.id.tituleMinutly);
            viewHolder.minutly_porcentaje =(TextView) view.findViewById(R.id.minutly_porcentaje);
            view.setTag(viewHolder);
            Log.d(TAG,"Construyendo una vista desde 0 ");
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.minutlyTitle.setText(minutly.getMinutlyTitle());
        viewHolder.minutly_porcentaje.setText(minutly.getMinutlyPorcentaje());
        return view;
    }
    static  class ViewHolder{
        TextView minutlyTitle;
        TextView minutly_porcentaje;
    }
}
