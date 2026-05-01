package pro1.apiDataModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ThesisDate {
    public String value;

    public boolean isValid() {
        return value != null && !value.isEmpty();
    }

    public LocalDate toLocalDate() {
        if (!isValid()) return null;
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("d.M.yyyy"));
    }
}