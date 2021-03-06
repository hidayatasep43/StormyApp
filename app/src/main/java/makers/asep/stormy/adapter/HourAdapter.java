package makers.asep.stormy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import makers.asep.stormy.R;
import makers.asep.stormy.weather.Hour;

/**
 * Created by hidayatasep43 on 29-Aug-16.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;
    private Context mContext;

    public HourAdapter(Hour[] hours, Context context){
        mHours = hours;
        mContext = context;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //dipanggil ketika membutuhkan view holder yang baru
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.hourly_list_item,parent,false);
        HourViewHolder viewHolder = new HourViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        //merupakan penghubung dengan adapter
        holder.bindHour(mHours[position]);
    }

    //return jumlah adata
    @Override
    public int getItemCount() {
        return mHours.length;
    }

    //view holde untuk recycler view
    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView timeLabel;
        TextView summaryLabel;
        TextView temperatureLabel;
        ImageView iconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            timeLabel = (TextView)itemView.findViewById(R.id.timeLabel);
            summaryLabel = (TextView)itemView.findViewById(R.id.summaryLabel);
            temperatureLabel = (TextView)itemView.findViewById(R.id.temperatureLabel);
            iconImageView = (ImageView)itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour){
            //set data
            timeLabel.setText(hour.getHour());
            summaryLabel.setText(hour.getSummary());
            temperatureLabel.setText(hour.getTemperature() + "");
            iconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View view) {
            //get data from view yang di click
            String time = timeLabel.getText().toString();
            String temperature = temperatureLabel.getText().toString();
            String summary = summaryLabel.getText().toString();
            String message = String.format("At %s it will be %s and %s",
                    time,
                    temperature,
                    summary);

            Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
        }
    }

}
