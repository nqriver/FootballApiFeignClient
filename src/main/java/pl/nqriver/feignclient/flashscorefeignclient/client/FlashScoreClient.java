package pl.nqriver.feignclient.flashscorefeignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import pl.nqriver.feignclient.flashscorefeignclient.client.dtos.EventsDto;

@FeignClient(value = "flashscoreclient", url = "https://flashscore.p.rapidapi.com")
public interface FlashScoreClient {
    @GetMapping(value = "/v1/teams/results?locale=en_GB&sport_id=1&team_id=Wtn9Stg0&page=1")
    EventsDto getMatches(@RequestHeader HttpHeaders httpHeaders);
}
