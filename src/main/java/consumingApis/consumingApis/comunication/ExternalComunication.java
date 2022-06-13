package consumingApis.consumingApis.comunication;

import consumingApis.consumingApis.comunication.Wrappers.CoinsWrapperDTO;
import consumingApis.consumingApis.comunication.Wrappers.DominanceWrapperDTO;
import consumingApis.consumingApis.comunication.Wrappers.SimpleCoinWrapperDTO;
import consumingApis.consumingApis.comunication.Wrappers.TrendingWrapperDTO;
import consumingApis.consumingApis.dto.BlockchainsDTO;
import consumingApis.consumingApis.dto.PingDTO;
import consumingApis.consumingApis.dto.SimpleCoinDTO;
import consumingApis.consumingApis.exception.InvalidCoinOrCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class ExternalComunication {
    @Autowired
    RestTemplate restTemplate;

    private final String URL = "https://api.coingecko.com/api/v3/";

    public CoinsWrapperDTO getCoins(String coin) {
        CoinsWrapperDTO response = restTemplate.getForObject(URL + "/search?query=" + coin, CoinsWrapperDTO.class);
        return response;
    }

    public PingDTO getPing() {
        PingDTO response = restTemplate.getForObject(URL + "ping", PingDTO.class);
        return response;
    }

    public SimpleCoinWrapperDTO getPrice(String coin, String currency) throws InvalidCoinOrCurrency{
        ParameterizedTypeReference<Map<String, String>> typeRef = new ParameterizedTypeReference<Map<String, String>>() {};
        if (!isInvalidCoinOrCurrency(coin, currency)) {
            throw new InvalidCoinOrCurrency("Invalid Coin or Currency");
        }
        SimpleCoinWrapperDTO response = restTemplate.getForObject(URL + "/simple/price?ids="+coin+"&vs_currencies=" + currency, SimpleCoinWrapperDTO.class);
        return response;
    }

    public DominanceWrapperDTO getDominance () {
        DominanceWrapperDTO response = restTemplate.getForObject(URL + "global", DominanceWrapperDTO.class);
        return response;
    }

    public TrendingWrapperDTO getTrending() {
        TrendingWrapperDTO response = restTemplate.getForObject(URL + "search/trending", TrendingWrapperDTO.class);
        return response;
    }

    public BlockchainsDTO[] getBlockchains() {
        ResponseEntity<BlockchainsDTO[]> response = restTemplate.getForEntity(URL + "/asset_platforms", BlockchainsDTO[].class);
        return response.getBody();
    }

    private boolean isInvalidCoinOrCurrency (String coin, String currency){
       /* for (Field field : SimpleCoinWrapperDTO.class.getDeclaredFields()) {
            System.out.println(field.getName().equals(coin));
            return true;
        }*/
        boolean existsCoin = Arrays.stream(SimpleCoinWrapperDTO.class.getDeclaredFields())
                .anyMatch(field -> field.getName().equals(coin));
        boolean existsCurrency = Arrays.stream(SimpleCoinDTO.class.getDeclaredFields())
                .anyMatch(field -> field.getName().equals(currency));
        return (!existsCoin || !existsCurrency) ? false : true;
    }


}
