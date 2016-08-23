package makers.asep.stormy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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


    public String getFormattedTime(){
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

    public double getTemperature() {
        return mTemperature;
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

    public double getPrecipChance() {
        return mPrecipChance;
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
