package my.mins.bot.api;

import lombok.Getter;
import lombok.Setter;

public class ApiDTO {

    @Getter
    @Setter
    public static class Req {

        private String message;
    }

    public static class Res {

    }
}
