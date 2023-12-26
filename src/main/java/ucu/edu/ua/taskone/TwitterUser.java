package ucu.edu.ua.taskone;

import java.time.LocalDateTime;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TwitterUser {
    private String email;
    private String userCountry;
    private LocalDateTime userActiveTime;
}
