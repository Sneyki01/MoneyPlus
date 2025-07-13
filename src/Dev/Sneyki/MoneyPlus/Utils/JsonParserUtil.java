package Dev.Sneyki.MoneyPlus.Utils;

import Dev.Sneyki.MoneyPlus.Models.ExchangeRateResponse;
import com.google.gson.Gson;

public class JsonParserUtil {
    public static ExchangeRateResponse parseRate (String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ExchangeRateResponse.class);
    }

}
