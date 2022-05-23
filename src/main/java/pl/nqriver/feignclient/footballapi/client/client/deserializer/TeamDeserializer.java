package pl.nqriver.feignclient.footballapi.client.client.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;
import pl.nqriver.feignclient.footballapi.client.client.response.Team;

import java.io.IOException;

@JsonComponent
public class TeamDeserializer extends JsonDeserializer<Team> {

    @Override
    public Team deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode jsonNode = codec.readTree(jsonParser);

        JsonNode response = jsonNode.get("response");
        JsonNode teamNode = response.get(0).get("team");

        long teamId = teamNode.get("id").longValue();
        String country = teamNode.get("country").textValue();
        String name = teamNode.get("name").textValue();
        return Team.builder()
                .id(teamId)
                .name(name)
                .country(country)
                .build();
    }
}
