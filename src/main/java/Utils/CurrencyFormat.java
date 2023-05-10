package Utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat {
    public static String covertPriceToString(double price){
        Locale locale = new Locale("vi","VN");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        String formattedAmount= currencyFormat.format(price);
        return formattedAmount;
    }

    public static double parseDouble(String price){
        String priceNew = price.replaceAll("\\D+","");
        return Double.parseDouble(priceNew);
    }

    public static int parseInteger(double price){
        String price1 = String.valueOf(price);
        String priceNew = price1.replaceAll("\\D+","");
        return Integer.parseInt(priceNew);
    }

}
