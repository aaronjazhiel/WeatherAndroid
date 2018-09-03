package mx.com.superfish.colorweather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapaterHourlyWeather extends BaseAdapter{


    public static  final String TAG = AdapaterHourlyWeather.class.getSimpleName();


    ArrayList hourList = new ArrayList();
    Context contexto;

    public AdapaterHourlyWeather(ArrayList hourList, Context contexto) {
        this.hourList = hourList;
        this.contexto = contexto;
    }

    @Override
    public int getCount() { return hourList.size();}

    @Override
    public Object getItem(int position) {
        return hourList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        Hour hour = (Hour) hourList.get(position);

        if(view == null) {
            view = LayoutInflater.from(contexto).inflate(R.layout.horly_weaher_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.hourlyTitle =(TextView) view.findViewById(R.id.tituleHourly);
            viewHolder.hourlyDescription =(TextView) view.findViewById(R.id.hourly_hora);
            view.setTag(viewHolder);
            Log.d(TAG,"Construyendo una vista desde 0 ");
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.hourlyTitle.setText(hour.getHora());
        viewHolder.hourlyDescription.setText(hour.getDescription());
        return view;
    }
    static  class ViewHolder{
        TextView hourlyTitle;
        TextView hourlyDescription;
    }
}
