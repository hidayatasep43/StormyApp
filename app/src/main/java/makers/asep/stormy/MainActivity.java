package makers.asep.stormy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import makers.asep.stormy.ui.AlertDialgFragment;
import makers.asep.stormy.weather.CurrentWeather;
import makers.asep.stormy.weather.ForeCast;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    //weather
    private ForeCast mForeCast;


    @BindView(R.id.timeTextView) TextView mTimeLabel;
    @BindView(R.id.tempetureTextView) TextView mTemperatureValue;
    @BindView(R.id.valueHumidityLabel) TextView mHumidityValue;
    @BindView(R.id.precipChanceValue) TextView mPrecipValue;
    @BindView(R.id.summaryValue) TextView mSummaryValue;
    @BindView(R.id.iconImageView) ImageView mIconImageView;
    @BindView(R.id.locationTextView) TextView mLocationValue;
    @BindView(R.id.refreshButton) ImageButton mRefreshButton;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //use butterKnife
        ButterKnife.bind(this);
        mRefreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getForecast();
            }
        });
        getForecast();

        //Main thread
        Log.d(TAG,"Ini Main activity...");

    }

    private void getForecast() {
        //add url to code
        String apiKey = "1de32f701f3be8533550c0bc903b7c40";
        double latitude = -6.896674;
        double longitude = 107.613668;
        String forecastUrl = "https://api.forecast.io/forecast/" + apiKey +
                "/" + latitude + "," + longitude;

        if(isNetworkAvailable()) {
            toggleShow();
            //deklarasi okhttp client
            OkHttpClient client = new OkHttpClient();
            //build request that the client will send to the server
            Request request = new Request.Builder().
                    url(forecastUrl)
                    .build();
            //call object
            Call call = client.newCall(request);
            Log.v(TAG, forecastUrl);
            //kode 2
            //asyntask proses untuk downloadd keterangan cuaca
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    //jika gagal
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleShow();
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    //show progress bar
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleShow();
                        }
                    });

                    //jika berhasil
                    //get data
                    String jsonData = response.body().string();
                    try {
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mForeCast = parseForecastDetails(jsonData);
                            //updata UI
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    updateUIDisplay();
                                }
                            });

                        } else {
                            alertUserAboutError();
                        }
                    } catch (JSONException e) {
                        Log.e(TAG, "Exception thought " + e.toString());
                    }
                }
            });
        }else{
            //jika tidak ada koneksi maka muncul toast
            Toast.makeText(this, "Network is Unvailable",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void toggleShow() {
        if(mProgressBar.getVisibility() == View.VISIBLE){
            mRefreshButton.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.INVISIBLE);
        }else{
            mRefreshButton.setVisibility(View.INVISIBLE);
            mProgressBar.setVisibility(View.VISIBLE);
        }

    }

    private void updateUIDisplay() {

        CurrentWeather mCurrentWeather = mForeCast.getCurrentWeather();

        mTemperatureValue.setText(mCurrentWeather.getTemperature() + " ");
        mTimeLabel.setText("At " + mCurrentWeather.getFormattedTime() + "it will be");
        mHumidityValue.setText(mCurrentWeather.getHumadity() + "");
        mPrecipValue.setText(mCurrentWeather.getPrecipChance() + "%");
        mSummaryValue.setText(mCurrentWeather.getSummary() + "");
        mLocationValue.setText(mCurrentWeather.getTimezone());

        //set image
        Drawable drawable = getResources().getDrawable(mCurrentWeather.getIconId());
        mIconImageView.setImageDrawable(drawable);
    }

    private ForeCast parseForecastDetails(String jsonData) throws JSONException {
        //masukan data ke forecast
        ForeCast foreCast = new ForeCast();
        foreCast.setCurrentWeather(getCurrentDetails(jsonData));

        return foreCast;
    }

    private CurrentWeather getCurrentDetails(String jsonData) throws JSONException {
        //getJSon object
        JSONObject forecast = new JSONObject(jsonData);
        //get timezone
        String timezone = forecast.getString("timezone");
        Log.i(TAG,"From JSON " + timezone);

        //get object currently
        JSONObject currently = forecast.getJSONObject("currently");

        //add atrbut cuaca
        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setHumadity(currently.getDouble("humidity"));
        currentWeather.setTime(currently.getLong("time"));
        currentWeather.setIcon(currently.getString("icon"));
        currentWeather.setPrecipChance(currently.getDouble("precipProbability"));
        currentWeather.setSummary(currently.getString("summary"));
        currentWeather.setTemperature(currently.getDouble("temperature"));
        currentWeather.setTimezone(timezone);

        Log.d(TAG,currentWeather.getFormattedTime());
        return currentWeather;
    }

    //check koneksi
    private boolean isNetworkAvailable() {
        //untuk mengecek koneksi
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        //check konektifitas
        if(networkInfo != null && networkInfo.isConnected()){
            //jika network aktif dan terkoneksi
            isAvailable = true;
        }
        //return status connect
        return isAvailable;
    }

    private void alertUserAboutError() {
        //memunculkan alertdialog
        AlertDialgFragment dialog = new AlertDialgFragment();
        dialog.show(getFragmentManager(),"error dialog");
    }
}
