package my.mins.bot.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class CommonService {

    private RestTemplate restTemplate = new RestTemplate();

    public <T> ResponseEntity<T> httpCall(String url, T reqData, Class<T> tClass) {
        return restTemplate.postForEntity(url, reqData, tClass);
    }

    public <T> ResponseEntity<T> httpCall(String url, Class<T> tClass) {
        return restTemplate.getForEntity(url, tClass);
    }

}
