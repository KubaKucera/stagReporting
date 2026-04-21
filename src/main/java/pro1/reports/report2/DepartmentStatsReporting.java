package pro1.reports.report2;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.Action;
import pro1.apiDataModel.ActionsList;
import pro1.reports.report2.reportDataModel.DepartmentStats;

public class DepartmentStatsReporting {

    public static DepartmentStats GetReport(DataSource dataSource, String rok, String katedra) {

        var json = dataSource.getRozvrhByKatedra(rok, katedra);
        var list = new Gson().fromJson(json, ActionsList.class);

        return new DepartmentStats(
                maxActionStudentsCount(list),
                emptyActionsCount(list),
                maxTeacherScore(list)
        );
    }

    private static long maxActionStudentsCount(ActionsList list) {

        long max = 0;

        if (list != null && list.items != null) {
            for (Action a : list.items) {

                long val = a.obsazeni == null ? 0 : a.obsazeni;
                max = Math.max(max, val);
            }
        }

        return max;
    }

    private static long emptyActionsCount(ActionsList list) {

        long count = 0;

        if (list != null && list.items != null) {
            for (Action a : list.items) {

                long val = a.obsazeni == null ? 0 : a.obsazeni;

                if (val == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static long maxTeacherScore(ActionsList list) {
        long maxScore = 0;

        if (list != null && list.items != null) {
            for (Action a : list.items) {
                if (a.ucitIdno != null) {
                    long currentTeacherScore = teacherScore(a.ucitIdno, list);
                    maxScore = Math.max(maxScore, currentTeacherScore);
                }
            }
        }
        return maxScore;
    }

    private static long teacherScore(long teacherId, ActionsList list) {
        long sum = 0;

        if (list != null && list.items != null) {
            for (Action a : list.items) {
                if (a.ucitIdno != null && a.ucitIdno == teacherId) {
                    long val = (a.obsazeni == null) ? 0 : a.obsazeni;
                    sum += val;
                }
            }
        }
        return sum;
    }
}