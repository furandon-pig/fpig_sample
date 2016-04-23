/* Today.java */

import java.util.Calendar;

public class Today {
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
        return sb.toString();
    }
}

