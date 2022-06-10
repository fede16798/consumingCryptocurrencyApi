package consumingApis.consumingApis.comunication;

import consumingApis.consumingApis.dto.PingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

    public SimpleCoinWrapperDTO getPrice(String coin, String currency) {
        SimpleCoinWrapperDTO response = restTemplate.getForObject(URL + "/simple/price?ids="+coin+"&vs_currencies=" + currency, SimpleCoinWrapperDTO.class);
        return response;
    }
}
