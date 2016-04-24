/* Today.java */

import java.util.Calendar;

public class Today {

    private static String week_list[] = {
        "日", "月", "火", "水", "木", "金", "土"
    };

    Calendar cal = null;

    Today() {
        cal = Calendar.getInstance();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cal.get(Calendar.YEAR));
        sb.append("年");
        sb.append(cal.get(Calendar.MONTH) + 1); // month is zero-origin
        sb.append("月");
        sb.append(cal.get(Calendar.DATE));
        sb.append("日");
        sb.append("(");
        sb.append(week_list[cal.get(Calendar.DAY_OF_WEEK) - 1]);
        sb.append(")");
        return sb.toString();
    }
}

