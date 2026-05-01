package pro1.reports.report3.reportDataModel;

import com.google.gson.annotations.SerializedName;

public class WeekdayStats {
    @SerializedName("weekday")
    public String weekday;

    @SerializedName("actionsCount")
    public int actionsCount;

    public WeekdayStats(String weekday, int actionsCount) {
        this.weekday = weekday;
        this.actionsCount = actionsCount;
    }
}