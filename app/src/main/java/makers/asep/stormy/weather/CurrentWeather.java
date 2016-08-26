package makers.asep.stormy.weather;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import makers.asep.stormy.R;

/**
 * Created by hidayatasep43 on 23-Aug-16.
 */
//model untuk data cuaca
public class CurrentWeather {
    public String mIcon;
    private long mTime;
    private double mTemperature;
    private double mHumadity;
    private double mPrecipChance;
    private String mSummary;
    private String mTimezone;

    public int getIconId(){
        int iconId = R.drawable.clear_day;
        if (mIcon.equals("clear-day")) {
            iconId = R.drawable.clear_day;
        }
        else if (mIcon.equals("clear-night")) {
            iconId = R.drawable.clear_night;
        }
        else if (mIcon.equals("rain")) {
            iconId = R.drawable.rain;
        }
        else if (mIcon.equals("snow")) {
            iconId = R.drawable.snow;
        }
        else if (mIcon.equals("sleet")) {
            iconId = R.drawable.sleet;
        }
        else if (mIcon.equals("wind")) {
            iconId = R.drawable.wind;
        }
        else if (mIcon.equals("fog")) {
            iconId = R.drawable.fog;
        }
        else if (mIcon.equals("cloudy")) {
            iconId = R.drawable.cloudy;
        }
        else if (mIcon.equals("partly-cloudy-day")) {
            iconId = R.drawable.partly_cloudy;
        }
        else if (mIcon.equals("partly-cloudy-night")) {
            iconId = R.drawable.cloudy_night;
        }
        return iconId;
    }

    public String getFormattedTime(){
        //format waktu
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        //get date yang sudah di format
        //set timezone
        format.setTimeZone(TimeZone.getTimeZone(getTimezone()));
        //get waktu
        Date dateTime =  new Date(getTime() * 1000);
        String timeString = format.format(dateTime);

        return timeString;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getTemperature() {
        return (int)Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getHumadity() {
        return mHumadity;
    }

    public void setHumadity(double humadity) {
        mHumadity = humadity;
    }

    public int getPrecipChance() {
        int principchnge = (int)Math.round((mPrecipChance*100));
        return principchnge;
    }

    public void setPrecipChance(double precipChance) {
        mPrecipChance = precipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }
}
