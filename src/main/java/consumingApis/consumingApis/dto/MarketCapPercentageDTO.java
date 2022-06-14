package consumingApis.consumingApis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MarketCapPercentageDTO {
    private Integer btc;
    private Integer eth;
    private Integer bnb;
    private Integer usdt;
    private Integer usdc;
    private Integer busd;
}
