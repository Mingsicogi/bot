package my.mins.bot.app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDTO {

    private String to;
    private String messages;
    private Boolean notificationDisabled;
}
