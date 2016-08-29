package makers.asep.stormy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import makers.asep.stormy.R;

/**
 * Created by hidayatasep43 on 29-Aug-16.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {



    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //view holde untuk recycler view
    public class HourViewHolder extends RecyclerView.ViewHolder{

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
        }
    }

}
