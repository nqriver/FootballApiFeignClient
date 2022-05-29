package pl.nqriver.feignclient.footballapi.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping("/teams/{teamId}/statistics")
    public ResponseEntity<Object> getForm(
            @RequestParam("league") Integer leagueId,
            @RequestParam("seasonYear") Optional<Year> seasonYear,
            @PathVariable Integer teamId)
    {
        var year = seasonYear.orElse(getCurrentSeasonYear());
        return ResponseEntity.ok().body(footballApiClient.getMatches(leagueId, year, teamId));
    }

    @GetMapping("/teams")
    public ResponseEntity<Object> getTeam(
            @RequestParam(value = "id", required = false) Integer teamId,
            @RequestParam(value = "name", required = false) String teamName
    ) {
        return ResponseEntity.ok().body(footballApiClient.getTeam(teamId, teamName));
    }

    @GetMapping("/leagues/{leagueId}/teams")
    public ResponseEntity<Object> getTeamsByLeague(
            @RequestParam(value = "season") Optional<Year> seasonYear,
            @PathVariable Integer leagueId)
    {
        var year = seasonYear.orElse(getCurrentSeasonYear());
        return ResponseEntity.ok().body(footballApiClient.getTeamsByLeague(leagueId, year));

    }

    private Year getCurrentSeasonYear() {
        return Year.now().minusYears(1);
    }

}
