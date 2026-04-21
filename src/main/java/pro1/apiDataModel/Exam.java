package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Exam {
    @SerializedName("obsazeni")
    public String obsazeni;

    @SerializedName("ucitIdno")
    public Long ucitIdno;
}
