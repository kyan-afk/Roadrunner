package main;

public class CurrencyConverterUtil {
    // Conversion rates based on 1 USD
    private static final double USD_TO_EUR = 1.0531;
    private static final double USD_TO_JPY = 151.55;
    private static final double USD_TO_GBP = 0.792;
    private static final double USD_TO_CAD = 1.4064;
    private static final double USD_TO_AUD = 1.5403;
    private static final double USD_TO_CNY = 7.16;
    private static final double USD_TO_PHP = 56.25;
    private static final double USD_TO_CHF = 0.884;
    private static final double USD_TO_INR = 83.15;
    private static final double USD_TO_KRW = 1327.89;
    private static final double USD_TO_MXN = 17.35;

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double rateFromUSD = getRateFromUSD(fromCurrency);
        double rateToUSD = getRateToUSD(toCurrency);

        // Convert the amount to USD first and then to the target currency
        double amountInUSD = amount * rateFromUSD;
        return amountInUSD * rateToUSD;
    }

    private static double getRateFromUSD(String currency) {
        switch (currency) {
            // Changed currency string formats to match those in JComboBox
            case "USD – United States Dollar ": return 1; // Note: Space at the end
            case "EUR - Euro European Union countries": return 1 / USD_TO_EUR; 
            case "JPY – Japanese Yen": return 1 / USD_TO_JPY;
            case "GBP – British Pound ": return 1 / USD_TO_GBP; // Note: Space before closing quote
            case "CAD – Canadian Dollar": return 1 / USD_TO_CAD;
            case "AUD – Australian Dollar": return 1 / USD_TO_AUD;
            case "CNY – Chinese Yuan": return 1 / USD_TO_CNY; // Fixed "CND" to "CNY"
            case "PHP – Philippine Peso": return 1 / USD_TO_PHP;
            case "CHF – Swiss Franc": return 1 / USD_TO_CHF;
            case "INR – Indian Rupee": return 1 / USD_TO_INR;
            case "KRW – South Korean Won": return 1 / USD_TO_KRW;
            case "MXN – Mexican Peso": return 1 / USD_TO_MXN;
            default: return 0;
        }
    }

    private static double getRateToUSD(String currency) {
        switch (currency) {
            case "USD – United States Dollar ": return 1; // Note: Space at the end
            case "EUR - Euro European Union countries": return USD_TO_EUR; 
            case "JPY – Japanese Yen": return USD_TO_JPY;
            case "GBP – British Pound ": return USD_TO_GBP; // Note: Space before closing quote
            case "CAD – Canadian Dollar": return USD_TO_CAD;
            case "AUD – Australian Dollar": return USD_TO_AUD;
            case "CNY – Chinese Yuan": return USD_TO_CNY; // Fixed "CND" to "CNY"
            case "PHP – Philippine Peso": return USD_TO_PHP;
            case "CHF – Swiss Franc": return USD_TO_CHF;
            case "INR – Indian Rupee": return USD_TO_INR;
            case "KRW – South Korean Won": return USD_TO_KRW;
            case "MXN – Mexican Peso": return USD_TO_MXN;
            default: return 0;
        }
    }
}