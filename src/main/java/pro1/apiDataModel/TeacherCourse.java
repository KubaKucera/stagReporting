package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class TeacherCourse
{
    @SerializedName("zkratka")
    public String zkratka;

    @SerializedName("nazev")
    public String nazev;
}
