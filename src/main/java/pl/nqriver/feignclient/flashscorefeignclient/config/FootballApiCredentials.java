package pl.nqriver.feignclient.flashscorefeignclient.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "rapidapi")
@Configuration("rapidapiProperties")
@Getter
@Setter
public class FootballApiCredentials {
    String key;
    String host;
}
