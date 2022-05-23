package pl.nqriver.feignclient.footballapi.client.client.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;
import pl.nqriver.feignclient.footballapi.client.client.response.Fixtures;
import pl.nqriver.feignclient.footballapi.client.client.response.Team;
import pl.nqriver.feignclient.footballapi.client.client.response.TeamForm;

import java.io.IOException;

@JsonComponent
public class TeamStatisticsDeserializer extends JsonDeserializer<TeamForm> {
    @Override
    public TeamForm deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode jsonNode = codec.readTree(jsonParser);
        JsonNode response = jsonNode.get("response");

        String form = response.get("form").textValue();
        Team team = getTeam(response);
        Fixtures fixtures = getFixtures(response);

        return TeamForm.builder()
                .fixtures(fixtures)
                .team(team)
                .form(form)
                .build();
    }

    private Fixtures getFixtures(JsonNode response) {
        JsonNode fixturesNode = response.get("fixtures");
        int wins = fixturesNode.get("wins").get("total").intValue();
        int draws = fixturesNode.get("draws").get("total").intValue();
        int loses = fixturesNode.get("loses").get("total").intValue();
        int overall = fixturesNode.get("played").get("total").intValue();
        return Fixtures.builder()
                .overallMatches(overall)
                .loses(loses)
                .wins(wins)
                .draws(draws)
                .build();

    }

    private Team getTeam(JsonNode response) {
        JsonNode teamNode = response.get("team");
        Long teamId = teamNode.get("id").asLong();
        String teamName = teamNode.get("name").asText();
        return Team.builder()
                .id(teamId)
                .name(teamName)
                .build();
    }
}
