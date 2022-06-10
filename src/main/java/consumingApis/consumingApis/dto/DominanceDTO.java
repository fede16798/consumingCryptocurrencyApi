package consumingApis.consumingApis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class DominanceDTO {
    private MarketCapPercentageDTO market_cap_percentage;
    private Integer market_cap_change_percentage_24h_usd;
}
