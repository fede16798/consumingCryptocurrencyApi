package consumingApis.consumingApis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleCoinDTO {
    private String usd;
    private String btc;
}
