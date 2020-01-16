package my.mins.bot.event.service.impl;

import com.linecorp.bot.model.event.Event;
import my.mins.bot.common.CommonService;
import my.mins.bot.event.service.EventCommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventCommonServiceImpl extends CommonService implements EventCommonService {

    @Override
    public boolean sendMessageToJmtServer(String url, Event event) {

        ResponseEntity<Event> joinEventResponseEntity = super.httpCall(url, event, Event.class);

        if(!joinEventResponseEntity.getStatusCode().is2xxSuccessful()) {

            // retry
            joinEventResponseEntity = super.httpCall(url, event, Event.class);
            if(joinEventResponseEntity.getStatusCode().is2xxSuccessful()) {
                return true;
            }

        } else {
            return true;
        }

        return false;
    }
}
