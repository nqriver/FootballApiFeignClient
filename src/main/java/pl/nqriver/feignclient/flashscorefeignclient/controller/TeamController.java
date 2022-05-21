package pl.nqriver.feignclient.flashscorefeignclient.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nqriver.feignclient.flashscorefeignclient.client.FootballApiClient;
import pl.nqriver.feignclient.flashscorefeignclient.config.FootballApiCredentials;

@RestController()
public class TeamController {

    private final FootballApiClient flashScoreClient;
    private final FootballApiCredentials footballApiCredentials;



    public TeamController(FootballApiClient flashScoreClient, FootballApiCredentials footballApiCredentials) {
        this.flashScoreClient = flashScoreClient;
        this.footballApiCredentials = footballApiCredentials;
    }


    @GetMapping("/matches")
    public ResponseEntity<Object> getForm() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Host", footballApiCredentials.getHost());
        headers.add("X-RapidAPI-Key", footballApiCredentials.getKey());
        return ResponseEntity.ok().body(flashScoreClient.getMatches(headers, 39, 2021, 33));
    }
}
