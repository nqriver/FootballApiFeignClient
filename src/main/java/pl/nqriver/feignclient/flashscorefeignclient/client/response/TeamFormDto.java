package pl.nqriver.feignclient.flashscorefeignclient.client.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import pl.nqriver.feignclient.flashscorefeignclient.client.deserializer.TeamStatisticsDeserializer;

@Data
@AllArgsConstructor
@JsonDeserialize(using = TeamStatisticsDeserializer.class)
public class TeamFormDto {
    String form;
}
