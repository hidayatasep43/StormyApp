package makers.asep.stormy.weather;

/**
 * Created by hidayatasep43 on 26-Aug-16.
 */
public class ForeCast {
    private CurrentWeather mCurrentWeather;

    public CurrentWeather getCurrentWeather() {
        return mCurrentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        mCurrentWeather = currentWeather;
    }

    public Hour[] getHours() {
        return mHours;
    }

    public void setHours(Hour[] hours) {
        mHours = hours;
    }

    public Day[] getDays() {
        return mDays;
    }

    public void setDays(Day[] days) {
        mDays = days;
    }

    private Hour[] mHours;
    private Day[] mDays;
}
