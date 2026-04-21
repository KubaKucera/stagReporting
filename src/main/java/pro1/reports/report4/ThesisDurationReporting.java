package pro1.reports.report4;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ThesisList;
import pro1.reports.report4.reportDataModel.ThesisDuration;

import java.time.temporal.ChronoUnit;

public class ThesisDurationReporting {

    public static Object[] GetReport(DataSource dataSource, String katedra, String[] years) {

        Object[] result = new ThesisDuration[years.length];

        for (int i = 0; i < years.length; i++) {

            var json = dataSource.getKvalifikacniPrace(years[i], katedra);
            var list = new Gson().fromJson(json, ThesisList.class);

            long sum = 0;
            int count = 0;

            if (list != null && list.items != null) {
                for (var t : list.items) {
                    if (t.datumZadani != null && t.datumZadani.isValid()
                            && t.datumOdevzdani != null && t.datumOdevzdani.isValid()) {

                        long days = ChronoUnit.DAYS.between(
                                t.datumZadani.toLocalDate(),
                                t.datumOdevzdani.toLocalDate()
                        );

                        sum += days;
                        count++;
                    }
                }
            }

            long avg = count == 0 ? 0 : Math.round((double) sum / count);

            result[i] = new ThesisDuration(years[i], avg);
        }

        return result;
    }
}