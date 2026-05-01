package pro1.reports.report4;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ThesisList;
import pro1.reports.report4.reportDataModel.ThesisYearStats;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class ThesisDurationReporting {

    public static ThesisYearStats[] GetReport(DataSource dataSource, String katedra, String[] years) {
        return Arrays.stream(years)
                .map(year -> new ThesisYearStats(year, averageDurationForYear(dataSource, year, katedra)))
                .toArray(ThesisYearStats[]::new);
    }

    private static int averageDurationForYear(DataSource dataSource, String year, String katedra) {
        var thesisJson = dataSource.getKvalifikacniPrace(year, katedra);
        var thesisList = new Gson().fromJson(thesisJson, ThesisList.class);

        var avg = thesisList.items.stream()
                .filter(t -> t.datumZadani != null && t.datumZadani.isValid())
                .filter(t -> t.datumOdevzdani != null && t.datumOdevzdani.isValid())
                .mapToLong(t -> ChronoUnit.DAYS.between(t.datumZadani.toLocalDate(), t.datumOdevzdani.toLocalDate()))
                .average()
                .orElse(0);
        return (int) Math.round(avg);
    }
}