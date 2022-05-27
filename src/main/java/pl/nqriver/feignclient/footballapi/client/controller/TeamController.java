package pl.nqriver.feignclient.footballapi.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.nqriver.feignclient.footballapi.client.client.FootballApiClient;

import java.time.Year;
import java.util.Optional;

@RestController
public class TeamController {

    private final FootballApiClient footballApiClient;


    public TeamController(FootballApiClient footballApiClient) {
        this.footballApiClient = footballApiClient;
    }


    @GetMapping("/team/statistics")
    public ResponseEntity<Object> getForm() {
        return ResponseEntity.ok().body(footballApiClient.getMatches(1, 2021, 33));
    }

    @GetMapping("/teams")
    public ResponseEntity<Object> getTeam(
            @RequestParam(value = "id", required = false) Integer teamId,
            @RequestParam(value = "name", required = false) String teamName
    ) {
        return ResponseEntity.ok().body(footballApiClient.getTeam(teamId, teamName));
    }

    @GetMapping("league/teams")
    public ResponseEntity<Object> getTeamsByLeague(
            @RequestParam(value = "league") Integer leagueId,
            @RequestParam(value = "season") Optional<Year> seasonYear
    )
    {
        var year = seasonYear.orElse(getCurrentSeasonYear());
        return ResponseEntity.ok().body(footballApiClient.getTeamsByLeague(leagueId, year));

    }

    private Year getCurrentSeasonYear() {
        return Year.now().minusYears(1);
    }

}
