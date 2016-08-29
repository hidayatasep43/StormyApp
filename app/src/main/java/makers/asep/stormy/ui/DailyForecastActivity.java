package makers.asep.stormy.ui;

import android.accessibilityservice.AccessibilityService;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.Arrays;

import makers.asep.stormy.MainActivity;
import makers.asep.stormy.R;
import makers.asep.stormy.adapter.DayAdapter;
import makers.asep.stormy.weather.Day;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        //get data from main activity
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        //convet data perseable ke array of day
        //parameer 1 = tipe data yang akan diubah
        //parameter 2 = jumlah data yang dirubah
        //parameter 3 =  tipe data setellah diubah
        mDays = Arrays.copyOf(parcelables,parcelables.length,Day[].class);
        //array adapter

        DayAdapter adapter = new DayAdapter(this,mDays);
        setListAdapter(adapter);
    }
}
