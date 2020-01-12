package my.mins.bot.app.impl;

import my.mins.bot.app.MessageAppCd;
import my.mins.bot.app.MessageCommonService;
import my.mins.bot.app.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LINEService implements MessageCommonService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${line.bot.channel-token}")
    private String accessToken;

    @Override
    public boolean send(MessageDTO message) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", accessToken);

        HttpEntity<MessageDTO> httpEntity = new HttpEntity<>(message, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(MessageAppCd.LINE.getPushMessageUrl(), httpEntity, String.class);
        if(response.getStatusCode().is2xxSuccessful()) {
            return true;
        }

        return false;
    }
}
