package consumingApis.consumingApis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CoinDTO {

    private String id;
    private String name;
    private String symbol;
    private Integer market_cap_rank;
    private String thumb;
    private String large;
}
