package consumingApis.consumingApis.exception;

import consumingApis.consumingApis.comunication.SimpleCoinWrapperDTO;
import consumingApis.consumingApis.dto.SimpleCoinDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class InvalidCoinOrCurrency extends Exception{
    private String message;
    private List<String> coins = new ArrayList<>();
    private List<String> currencies = new ArrayList<>();

    public InvalidCoinOrCurrency (String message) {
        for (Field field: SimpleCoinWrapperDTO.class.getDeclaredFields()) {
            coins.add(field.getName());
        }
        for (Field field: SimpleCoinDTO.class.getDeclaredFields()) {
            currencies.add(field.getName());
        }
        this.message = message + ". Try with some of these values for currency: "
                + currencies
                + " Or these values for coins: "
                + coins;
    }


}
