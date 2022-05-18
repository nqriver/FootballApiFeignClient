package pl.nqriver.feignclient.flashscorefeignclient.client.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventDto {

    @JsonProperty("EVENT_ID")
    private String id;
}
