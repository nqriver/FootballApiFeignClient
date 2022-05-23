package pl.nqriver.feignclient.footballapi.client.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.nqriver.feignclient.footballapi.client.client.FootballApiClient;
import pl.nqriver.feignclient.footballapi.client.config.FootballApiCredentials;

import java.time.Year;
import java.util.Optional;

@RestController()
public class TeamController {

    private final FootballApiClient footballApiClient;
    private final FootballApiCredentials footballApiCredentials;


    public TeamController(FootballApiClient footballApiClient, FootballApiCredentials footballApiCredentials) {
        this.footballApiClient = footballApiClient;
        this.footballApiCredentials = footballApiCredentials;
    }


    @GetMapping("/team/statistics")
    public ResponseEntity<Object> getForm() {
        HttpHeaders headers = getHttpHeaders();
        return ResponseEntity.ok().body(footballApiClient.getMatches(headers, 1, 2021, 33));
    }

    @GetMapping("/teams")
    public ResponseEntity<Object> getTeam(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String teamName
    ) {
        HttpHeaders headers = getHttpHeaders();
        return ResponseEntity.ok().body(footballApiClient.getTeam(headers, id, teamName));
    }

    @GetMapping("league/teams")
    public ResponseEntity<Object> getTeamsByLeague(
            @RequestParam(value = "league") Long leagueId,
            @RequestParam(value = "season") Optional<Year> seasonYear
    ) {
        var headers = getHttpHeaders();
        var year = getCurrentSeasonYear();
        return ResponseEntity.ok().body(footballApiClient.getTeamsByLeague(headers, leagueId, year));

    }

    private Year getCurrentSeasonYear() {
        return Year.now().minusYears(1);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Host", footballApiCredentials.getHost());
        headers.add("X-RapidAPI-Key", footballApiCredentials.getKey());
        return headers;
    }
}
