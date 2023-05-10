package Views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateUtils {
    public static final String NAME_REGEX = "^([A-ZÀ-ỹ][a-zÀ-ỹ]*[ ]?)+$";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
    public static final String ADDREE_REGEX = "^([^. ][.]*[ ]?)+$";

    public static boolean isNameValid(String name){
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }
    public static boolean isPhoneValid(String number){
        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }
    public static boolean isAddValid(String addree){
        return Pattern.compile(ADDREE_REGEX).matcher(addree).matches();
    }

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    public static Date parseDate(String strDate){
        try {
            return simpleDateFormat.parse(strDate);
        }catch (ParseException e){
            e.printStackTrace();
        } return null;
    }

    public static String formatDate( Date date){
        return simpleDateFormat.format(date);
    }
}
