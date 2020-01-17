package my.mins.bot.event;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import lombok.extern.slf4j.Slf4j;

@LineMessageHandler
@Slf4j
public class TextMessageHandling {

    @EventMapping
    public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        log.info("#### event : " + event);

        log.info("#### source : " + event.getSource());
        log.info("#### group id : " + event.getSource().getSenderId()); // group id
        log.info("#### user id : " + event.getSource().getUserId()); // user id


        final String originalMessageText = event.getMessage().getText();
        return new TextMessage("지금은 개발중~!");
    }
}
