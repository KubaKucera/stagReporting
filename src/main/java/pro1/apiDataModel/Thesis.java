package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Thesis {
    @SerializedName("datumZadani")
    public Date datumZadani;

    @SerializedName("datumOdevzdani")
    public Date datumOdevzdani;
}
