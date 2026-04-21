package pro1.reports.report3;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ActionsList;
import pro1.reports.report3.reportDataModel.WeekdayStats;

public class DepartmentWeekdayReporting {

    public static Object[] GetReport(DataSource dataSource, String rok, String katedra, String[] days) {

        var json = dataSource.getRozvrhByKatedra(rok, katedra);
        var list = new Gson().fromJson(json, ActionsList.class);

        Object[] result = new WeekdayStats[days.length];

        for (int i = 0; i < days.length; i++) {
            long count = 0;

            if (list != null && list.items != null) {
                for (var a : list.items) {
                    if (a.denZkr != null && days[i].equals(a.denZkr)) {
                        count++;
                    }
                }
            }

            result[i] = new WeekdayStats(days[i], count);
        }

        return result;
    }
}