package pro1.reports.report5;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ExamsList;
import pro1.reports.report5.reportDataModel.DepartmentExamsStats;

public class DepartmentExamsStatsReporting {

    public static DepartmentExamsStats GetReport(DataSource dataSource, String katedra) {
        var examsJson = dataSource.getTerminyZkousek2(katedra);
        var examsList = new Gson().fromJson(examsJson, ExamsList.class);

        return new DepartmentExamsStats(
            realizedExamsCount(examsList),
            teacherIds(examsList)
        );
    }

    private static int realizedExamsCount(ExamsList examsList) {
    return (int) examsList.items.stream()
        .filter(e -> e.studentsCount > 0)
        .count();
    }

    private static long[] teacherIds(ExamsList examsList) {
    return examsList.items.stream()
        .map(e -> e.teacherID)
        .filter(id -> id != null)
        .mapToLong(Long::longValue)
        .distinct()
        .sorted()
        .toArray();
    }
}