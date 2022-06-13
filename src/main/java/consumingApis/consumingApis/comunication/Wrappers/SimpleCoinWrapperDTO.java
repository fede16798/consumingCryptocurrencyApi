package consumingApis.consumingApis.comunication.Wrappers;

import com.fasterxml.jackson.annotation.JsonInclude;
import consumingApis.consumingApis.dto.SimpleCoinDTO;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleCoinWrapperDTO {
    SimpleCoinDTO bitcoin;
    SimpleCoinDTO ethereum;
    SimpleCoinDTO dogecoin;
    SimpleCoinDTO cardano;
    SimpleCoinDTO solana;
    SimpleCoinDTO chiliz;
    SimpleCoinDTO decentraland;

}
