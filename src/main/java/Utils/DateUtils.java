package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public static Date parseDate(String strDate) {
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        } return null;
    }

    //date -> '10-4-2023 14:16:30'
    public static String formatDate(Date date){
        return simpleDateFormat.format(date);
    }
}
