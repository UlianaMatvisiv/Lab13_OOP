package ucu.edu.ua.taskone;

import java.time.LocalDate;

public interface User {
    public String getEmail();
    public String getCountry();
    public LocalDate getLastActiveDate();
}
