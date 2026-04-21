package pro1.reports.report5;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.Exam;
import pro1.apiDataModel.ExamsList;
import pro1.reports.report5.reportDataModel.ExamsStats;

import java.util.*;

public class DepartmentExamsStatsReporting {

    public static ExamsStats GetReport(DataSource dataSource, String katedra) {

        var json = dataSource.getTerminyZkousek2(katedra);
        var list = new Gson().fromJson(json, ExamsList.class);

        long realized = 0;
        Set<Long> teachers = new TreeSet<>();

        if (list != null && list.items != null) {
            for (var e : list.items) {
                int obsazeni = (e.obsazeni != null && !e.obsazeni.isEmpty() ? Integer.parseInt(e.obsazeni) : 0);

                if (obsazeni > 0) {
                    realized++;
                }

                if (e.ucitIdno != null) {
                    teachers.add(e.ucitIdno);
                }
            }
        }

        return new ExamsStats(realized, new ArrayList<>(teachers));
    }
}