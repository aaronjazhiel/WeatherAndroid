package mx.com.superfish.colorweather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapaterDailyWeather  extends BaseAdapter{


    public static  final String TAG = AdapaterDailyWeather.class.getSimpleName();


    ArrayList dayList = new ArrayList();
    Context contexto;


    public AdapaterDailyWeather(ArrayList dayList, Context contexto) {
        this.dayList = dayList;
        this.contexto = contexto;
    }

    @Override
    public int getCount() { return dayList.size();}

    @Override
    public Object getItem(int position) {
        return dayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        Day day = (Day) dayList.get(position);

        if(view == null) {

            view = LayoutInflater.from(contexto).inflate(R.layout.daily_list_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.dayTitle =(TextView) view.findViewById(R.id.dalyTitule);
            viewHolder.dayDescription =(TextView) view.findViewById(R.id.dailyDescription);
            viewHolder.dayPoc =(TextView) view.findViewById(R.id.dailyProbability);
            view.setTag(viewHolder);
            Log.d(TAG,"Construyendo una vista desde 0 ");

        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.dayTitle.setText(day.getTitulo());
        viewHolder.dayDescription.setText(day.getDescription());
        viewHolder.dayPoc.setText(day.getProcentaje());
        return view;
    }

    static  class ViewHolder{
        TextView dayTitle;
        TextView dayDescription;
        TextView dayPoc;
    }
}
