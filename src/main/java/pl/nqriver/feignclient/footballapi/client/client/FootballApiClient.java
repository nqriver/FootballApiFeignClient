package pl.nqriver.feignclient.footballapi.client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nqriver.feignclient.footballapi.client.client.response.Team;
import pl.nqriver.feignclient.footballapi.client.client.response.TeamForm;
import pl.nqriver.feignclient.footballapi.client.config.FeignConfig;

import java.time.Year;

@FeignClient(value = "footballClient", url = "${footbal-api-url}", configuration = FeignConfig.class)
public interface FootballApiClient {


    @RequestMapping(method = RequestMethod.GET,
            value = "/teams/statistics",
            produces = MediaType.APPLICATION_JSON_VALUE)
    TeamForm getMatches(
            @RequestHeader HttpHeaders httpHeaders,
            @RequestParam("league") Integer leagueId,
            @RequestParam("season") Integer seasonId,
            @RequestParam("team") Integer teamId
    );


    @RequestMapping(method = RequestMethod.GET,
            value = "/teams",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Team getTeam(
            @RequestHeader HttpHeaders headers,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String teamName
    );

    @RequestMapping(method = RequestMethod.GET,
            value = "/teams",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Object getTeamsByLeague(
            @RequestHeader HttpHeaders headers,
            @RequestParam(value = "league") Long leagueId,
            @RequestParam(value = "season", required = false) Year seasonYear
    );
}
