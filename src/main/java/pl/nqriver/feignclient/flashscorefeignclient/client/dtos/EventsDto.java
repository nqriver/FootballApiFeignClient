package pl.nqriver.feignclient.flashscorefeignclient.client.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.Set;

@Data
@JsonRootName("DATA")
public class EventsDto {
    @JsonProperty("EVENTS")
    Set<EventDto> events;
}
