package example.lgcode.launchstatus.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leojg on 2/15/17.
 */

public class  DateProvider {

    private static String date;

    public static String getCurrentDate() {
        if (date == null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.format(new Date());
        }
        return date;
    }
}
