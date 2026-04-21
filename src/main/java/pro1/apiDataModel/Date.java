package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    @SerializedName("value")
    public String value;

    public boolean isValid() {
        return value != null && value.contains(".");
    }

    public LocalDate toLocalDate() {
        if (value == null || value.isBlank()) return null;

        try {
            String datePart = value.split(" ")[0];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

            return LocalDate.parse(datePart, formatter);
        } catch (Exception e) {
            return null;
        }
    }
}
