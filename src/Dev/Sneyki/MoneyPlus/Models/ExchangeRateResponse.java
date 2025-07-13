package Dev.Sneyki.MoneyPlus.Models;

public record ExchangeRateResponse(
        String result,
        String base_code,
        String target_code,
        double conversion_rate
) {
}
