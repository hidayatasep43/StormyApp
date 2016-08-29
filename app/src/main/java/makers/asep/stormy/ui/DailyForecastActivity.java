package makers.asep.stormy.ui;

import android.accessibilityservice.AccessibilityService;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

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

        String[] daysOfTheWeek = { "Sunday", "Monday", "Tuesday",
                "Wednesday", "Thursday", "Friday", "Saturday" };

        //get data from main activity
        Intent intent = getIntent();
        mDays = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);

        //array adapter
        DayAdapter adapter = new DayAdapter(this,mDays);

    }
}
