package pl.nqriver.feignclient.flashscorefeignclient.client.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;
import pl.nqriver.feignclient.flashscorefeignclient.client.response.TeamFormDto;

import java.io.IOException;

@JsonComponent
public class TeamStatisticsDeserializer extends JsonDeserializer<TeamFormDto> {
    @Override
    public TeamFormDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode treeNode = codec.readTree(jsonParser);
        JsonNode response = treeNode.get("response");
        String form = response.get("form").textValue();

        return new TeamFormDto(form);
    }
}
