package ucu.edu.ua.taskone;

import lombok.Data;
import lombok.Getter;
import java.time.LocalDateTime;

@Data @Getter
public class FacebookUser {
    private String email;
    private String userCountry;
    private LocalDateTime lastActiveTime;
}