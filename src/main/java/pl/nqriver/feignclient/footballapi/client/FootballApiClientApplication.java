package pl.nqriver.feignclient.footballapi.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FootballApiClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballApiClientApplication.class, args);
    }

}
