import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yzhao on 7/13/16.
 */
public class DateToIntegerMain {
    public static void main(String[] args){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse("2016-07-01 01:48:39");
        }catch (Exception e){

        }


        System.out.println(new java.sql.Date(date.getTime()));
    }
}
