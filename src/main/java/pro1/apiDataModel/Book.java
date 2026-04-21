package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Book
{
    @SerializedName("nazev")
    public String nazev;

    @SerializedName("autor")
    public String autor;
}
