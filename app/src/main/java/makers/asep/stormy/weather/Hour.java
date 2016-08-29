package makers.asep.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hidayatasep43 on 26-Aug-16.
 */
public class Hour implements Parcelable {
    private long mTime;
    private String Summary;
    private double mTemperature;
    private String mIcon;
    private String mTimeZone;


    public Hour(){

    }



    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel in) {
            return new Hour(in);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mTime);
        parcel.writeString(Summary);
        parcel.writeDouble(mTemperature);
        parcel.writeString(mIcon);
        parcel.writeString(mTimeZone);
    }

    protected Hour(Parcel in) {
        mTime = in.readLong();
        Summary = in.readString();
        mTemperature = in.readDouble();
        mIcon = in.readString();
        mTimeZone = in.readString();
    }


}
