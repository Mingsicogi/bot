package my.mins.bot.app;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MesaageAppCd {

    KAKAO(false, "", ""),
    LINE(true, "https://api.line.me", "/v2/bot/message/push");

    private boolean isUse;
    private String apiUrl;
    private String pushMsaageUri;
}
