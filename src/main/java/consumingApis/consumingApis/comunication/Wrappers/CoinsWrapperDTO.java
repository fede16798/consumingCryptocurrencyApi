package consumingApis.consumingApis.comunication.Wrappers;
import consumingApis.consumingApis.dto.CoinDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class CoinsWrapperDTO {
    private List<CoinDTO> coins;
}
