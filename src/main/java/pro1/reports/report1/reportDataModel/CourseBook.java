package pro1.reports.report1.reportDataModel;

public class CourseBook
{
    public String title;
    public String author;
    public String courseCode;

    public CourseBook(String courseCode, String author, String title) {
        this.courseCode = courseCode;
        this.author = author;
        this.title = title;
    }
}
