package makers.asep.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by hidayatasep43 on 26-Aug-16.
 */
public class Day implements Parcelable{
    private long mTime;
    private String mSummary;
    private double mTemperatureMax;
    private String mIcon;
    private String mTimezone;

    public Day(){

    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperatureMax() {
        return (int)Math.round(mTemperatureMax);
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    //get icon
    public int getIconId() {
        //get from forecast
        return ForeCast.getIconId(mIcon);
    }

    //getDay
    public String getDayOfTheWeek(){
        //format untuk hari
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd - MM");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date dateTime = new Date(mTime * 1000);
        //return day
        return formatter.format(dateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        //write all property
        /*
        *  private long mTime;
            private String mSummary;
            private double mTemperatureMax;
            private String mIcon;
            private String mTimezone;
        * */
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeString(mIcon);
        dest.writeString(mTimezone);
        dest.writeDouble(mTemperatureMax);
    }

    //untuk membaca parceable
    private Day (Parcel in){
        mTime = in.readLong();
        mSummary = in.readString();
        mIcon = in.readString();
        mTimezone = in.readString();
        mTemperatureMax = in.readDouble();
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel parcel) {
            return new Day(parcel);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };
}
