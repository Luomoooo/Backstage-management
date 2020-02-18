package fun.luomo.utils;

import java.sql.Ref;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Luomo
 * @since 2020/2/15 12:47
 */
public class DateUtils {

    public static String date2String(Date date, String patt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patt);

        String format = dateFormat.format(date);
        return format;
    }

    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patt);

        Date parse = dateFormat.parse(str);
        return parse;
    }
}
