package my.mins.bot.event;

import com.linecorp.bot.model.event.JoinEvent;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import lombok.extern.slf4j.Slf4j;
import my.mins.bot.event.service.EventCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@LineMessageHandler
@Slf4j
public class JoinEventHandling {

    @Autowired
    private EventCommonService eventCommonService;

    @Value("${domain}")
    private String jmtDomain;

    @EventMapping
    public void joinEventHandling(JoinEvent event) {
        log.info("#### event : {}", event);
        log.info("#### source : {}", event.getSource());

        eventCommonService.sendMessageToJmtServer(jmtDomain + "/event/message/join", event);
    }
}
