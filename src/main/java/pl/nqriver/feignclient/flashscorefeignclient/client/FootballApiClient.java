package pl.nqriver.feignclient.flashscorefeignclient.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nqriver.feignclient.flashscorefeignclient.client.response.TeamFormDto;

@FeignClient(value = "footballClient", url = "${footbal-api-url}")
public interface FootballApiClient {



    @RequestMapping(method = RequestMethod.GET,
            value = "/teams/statistics",
            produces = MediaType.APPLICATION_JSON_VALUE)
    TeamFormDto getMatches(
            @RequestHeader HttpHeaders httpHeaders,
            @RequestParam("league") Integer leagueId,
            @RequestParam("season") Integer seasonId,
            @RequestParam("team") Integer teamId
    );
}
