package makers.asep.stormy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import makers.asep.stormy.R;
import makers.asep.stormy.weather.Day;

/**
 * Created by hidayatasep43 on 28-Aug-16.
 */
public class DayAdapter extends BaseAdapter {

    private Context mContext;
    //day
    private Day[] mDays;

    public DayAdapter(Context context,Day[] Days){
        mContext = context;
        mDays = Days;
    }

    //mengembalika jumlah hari
    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int i) {
        return mDays[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(convertView == null){
            //jika belum ada view untuk ditampilkan
            //create new view
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item,null);

            viewHolder = new ViewHolder();
            viewHolder.iconImageView = (ImageView)convertView.findViewById(R.id.iconImageView);
            viewHolder.temperatureLabel = (TextView)convertView.findViewById(R.id.temperatureLabel);
            viewHolder.dayLabel = (TextView)convertView.findViewById(R.id.temperatureLabel);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }


        //set data
        Day day = mDays[position];
        viewHolder.iconImageView.setImageResource(day.getIconId());
        viewHolder.temperatureLabel.setText(day.getTemperatureMax() + "");
        viewHolder.dayLabel.setText(day.getDayOfTheWeek());


        return null;
    }

    //class for reuse view
    private static class ViewHolder{
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayLabel;
    }
}
