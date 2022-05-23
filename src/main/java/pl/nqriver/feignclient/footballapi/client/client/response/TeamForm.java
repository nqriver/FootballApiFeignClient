package pl.nqriver.feignclient.footballapi.client.client.response;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import pl.nqriver.feignclient.footballapi.client.client.deserializer.TeamStatisticsDeserializer;

import java.time.Year;

@JsonDeserialize(using = TeamStatisticsDeserializer.class)
@Data
@Builder
public class TeamForm {
    Year year;
    Team team;
    Fixtures fixtures;
    String form;
}
