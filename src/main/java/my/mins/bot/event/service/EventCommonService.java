package my.mins.bot.event.service;

import com.linecorp.bot.model.event.Event;

public interface EventCommonService {

    boolean sendMessageToJmtServer(String url, Event event);
}
