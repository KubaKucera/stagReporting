package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Action {

    @SerializedName("obsazeni")
    public Long obsazeni;

    @SerializedName("planObsazeni")
    public Long planObsazeni;

    @SerializedName("ucitIdno")
    public Long ucitIdno;

    @SerializedName("denZkr")
    public String denZkr;

    @SerializedName("ucitel")
    public Ucitel ucitel;
}
