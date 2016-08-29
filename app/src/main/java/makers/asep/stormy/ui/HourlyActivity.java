package makers.asep.stormy.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import makers.asep.stormy.MainActivity;
import makers.asep.stormy.R;
import makers.asep.stormy.adapter.HourAdapter;
import makers.asep.stormy.weather.Hour;

public class HourlyActivity extends AppCompatActivity {

    private Hour[] mHours;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly);

        ButterKnife.bind(this);
        //get data from intent
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        mHours = Arrays.copyOf(parcelables,parcelables.length,Hour[].class);

        //memanggil adapter
        HourAdapter adapter = new HourAdapter(mHours,this);
        mRecyclerView.setAdapter(adapter);

        //menggunakan layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        //untuk mengingkatkan performa list
        mRecyclerView.setHasFixedSize(true);


    }
}
