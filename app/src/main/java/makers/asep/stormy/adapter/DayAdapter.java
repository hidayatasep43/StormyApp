package makers.asep.stormy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    //class for reuse view

}
