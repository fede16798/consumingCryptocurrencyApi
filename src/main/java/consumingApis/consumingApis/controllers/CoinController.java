package consumingApis.consumingApis.controllers;

import consumingApis.consumingApis.comunication.CoinsWrapperDTO;
import consumingApis.consumingApis.comunication.DominanceWrapperDTO;
import consumingApis.consumingApis.comunication.ExternalComunication;
import consumingApis.consumingApis.comunication.SimpleCoinWrapperDTO;
import consumingApis.consumingApis.dto.PingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/coins")
public class CoinController {
    @Autowired
    ExternalComunication externalComunication;

    @GetMapping("/search")
    public ResponseEntity<CoinsWrapperDTO> getCoins(@RequestParam String coin) {
        return ResponseEntity.ok().body(externalComunication.getCoins(coin));
    }

    @GetMapping("/ping")
    public ResponseEntity<PingDTO> getPing() {
        return ResponseEntity.ok().body(externalComunication.getPing());
    }

    @GetMapping("/bitcoin/price")
    public ResponseEntity<SimpleCoinWrapperDTO> getBitcoinPrice (@RequestParam String coin, @RequestParam String currency) {
        return ResponseEntity.ok().body(externalComunication.getPrice(coin, currency));
    }

    @GetMapping("/dominance")
    public ResponseEntity<DominanceWrapperDTO> getDominance () {
        return ResponseEntity.ok().body(externalComunication.getDominance());
    }
}
