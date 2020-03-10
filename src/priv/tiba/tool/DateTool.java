package priv.tiba.tool;

import java.util.Calendar;
import java.util.Date;

public class DateTool {
    public static int getsdays(Calendar a, Calendar b) {
        if(b.after(a)) {
            Calendar temp;
            temp=a;
            a=b;
            b=temp;
        }
        int days=a.get(Calendar.DAY_OF_YEAR)-b.get(Calendar.DAY_OF_YEAR);
        if(a.get(Calendar.YEAR)!=b.get(Calendar.YEAR)) {
            do {
                days+=a.getActualMaximum(Calendar.DAY_OF_YEAR);
                a.add(Calendar.YEAR, 1);
            }
            while(a.get(Calendar.YEAR)!=b.get(Calendar.YEAR));
        }
        return days;
    }

    public static Date getDateBefore(Date d, int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
        return now.getTime();
    }
}
