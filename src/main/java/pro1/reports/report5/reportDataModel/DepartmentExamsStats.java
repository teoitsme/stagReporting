package pro1.reports.report5.reportDataModel;

public class DepartmentExamsStats {
    public int realizedExamsCount;
    public long[] teacherIds;

    public DepartmentExamsStats(int realizedExamsCount, long[] teacherIds) {
        this.realizedExamsCount = realizedExamsCount;
        this.teacherIds = teacherIds;
    }
}