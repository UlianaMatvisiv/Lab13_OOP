package ucu.edu.ua.taskone;

import java.time.LocalDate;

public interface User {
    String getEmail();
    String getCountry();
    LocalDate getLastActiveDate();
}
