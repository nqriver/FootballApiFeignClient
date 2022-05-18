package pl.nqriver.feignclient.flashscorefeignclient.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nqriver.feignclient.flashscorefeignclient.client.FlashScoreClient;
import pl.nqriver.feignclient.flashscorefeignclient.client.dtos.EventDto;
import pl.nqriver.feignclient.flashscorefeignclient.client.dtos.EventsDto;

import java.util.HashSet;
import java.util.Set;

@RestController()
public class TeamController {

    private final FlashScoreClient flashScoreClient;

    public TeamController(FlashScoreClient flashScoreClient) {
        this.flashScoreClient = flashScoreClient;
    }

    @GetMapping("/matches")
    public ResponseEntity<EventsDto> getMatches() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Host", "flashscore.p.rapidapi.com");
        headers.add("X-RapidAPI-Key", "004e02d551msh4cca862ec76a736p15fe9cjsndb0337a1863f");
        return ResponseEntity.ok().body(flashScoreClient.getMatches(headers));
    }

    @GetMapping("/events")
    public EventsDto getSampleEvents() {
        EventsDto eventsDto = new EventsDto();
        HashSet<EventDto> events = new HashSet<>(Set.of(
                new EventDto("asd"),
                new EventDto("aaad")
        ));
        eventsDto.setEvents(events);
        return eventsDto;
    }
}
