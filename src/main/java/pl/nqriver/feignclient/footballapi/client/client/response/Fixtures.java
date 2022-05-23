package pl.nqriver.feignclient.footballapi.client.client.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fixtures {
    Integer overallMatches;
    Integer wins;
    Integer loses;
    Integer draws;
}
