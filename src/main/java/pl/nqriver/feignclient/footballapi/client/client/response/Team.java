package pl.nqriver.feignclient.footballapi.client.client.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import pl.nqriver.feignclient.footballapi.client.client.deserializer.TeamDeserializer;

@JsonDeserialize(using = TeamDeserializer.class)
@Data
@Builder
public class Team {
    Long id;
    String name;
    String country;
}
