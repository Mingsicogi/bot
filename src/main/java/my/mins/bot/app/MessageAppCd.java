package my.mins.bot.app;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageAppCd {

    KAKAO(false, "", ""),
    LINE(true, "https://api.line.me", "/v2/bot/message/push");

    private boolean isUse;
    private String apiUrl;
    private String pushMessageUri;

    public String getPushMessageUrl() {
        return this.apiUrl + this.pushMessageUri;
    }
}
