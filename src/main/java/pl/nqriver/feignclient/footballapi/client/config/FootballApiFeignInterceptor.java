package pl.nqriver.feignclient.footballapi.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class FootballApiFeignInterceptor implements RequestInterceptor {

    private final FootballApiCredentials footballApiCredentials;

    public FootballApiFeignInterceptor(FootballApiCredentials footballApiCredentials) {
        this.footballApiCredentials = footballApiCredentials;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Map<String, Collection<String>> headers = new HashMap<>();
        headers.put("X-RapidAPI-Host", Collections.singletonList(footballApiCredentials.getHost()));
        headers.put("X-RapidAPI-Key", Collections.singletonList(footballApiCredentials.getKey()));
        requestTemplate.headers(headers);
    }
}
