package consumingApis.consumingApis.comunication.Wrappers;

import consumingApis.consumingApis.dto.ItemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class TrendingWrapperDTO {
    private List<ItemDTO> coins;
}
