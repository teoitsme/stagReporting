package pro1.reports.report3;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ActionsList;
import pro1.reports.report3.reportDataModel.WeekdayStats;
import java.util.Arrays;

public class DepartmentWeekdaysReporting {

    public static WeekdayStats[] GetReport(DataSource dataSource, String rok, String katedra, String[] days) {
        var actionsListJson = dataSource.getRozvrhByKatedra(rok, katedra);
        var actionsList = new Gson().fromJson(actionsListJson, ActionsList.class);

        return Arrays.stream(days)
                .map(day -> new WeekdayStats(day, countActionsForDay(day, actionsList)))
                .toArray(WeekdayStats[]::new);
    }

    private static int countActionsForDay(String weekday, ActionsList actionsList) {
        if (actionsList.items == null) return 0;

        return (int) actionsList.items.stream()
                .filter(a -> weekday.equals(a.denZkr))
                .count();
    }
}