package pro1.reports.report1;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.BooksList;
import pro1.apiDataModel.TeacherCourse;
import pro1.apiDataModel.TeacherCoursesList;
import pro1.reports.report1.reportDataModel.CourseBook;

import java.util.ArrayList;
import java.util.List;

public class TeacherBooksReporting {

    public static List<CourseBook> GetReport(DataSource dataSource, String rok, int ucitIdno, String katedra){

        var coursesJson = dataSource.getPredmetyByUcitel(rok, ucitIdno, katedra);
        var courses = new Gson().fromJson(coursesJson, TeacherCoursesList.class);

        List<CourseBook> result = new ArrayList<>();

        if (courses != null && courses.items != null) {
            for (TeacherCourse c : courses.items) {

                var booksJson = dataSource.getLiteraturaPredmetu(c.zkratka, katedra);
                var books = new Gson().fromJson(booksJson, BooksList.class);

                if (books != null && books.items != null) {
                    for (var b : books.items) {
                        result.add(new CourseBook(c.zkratka, b.autor, b.nazev));
                    }
                }
            }
        }

        return result;
    }
}