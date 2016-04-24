/* Nengo.java */

import java.util.Date;
import java.util.Calendar;

public class Nengo {

    private static final int NUM_CHAR_BASE = 48; // 48 is '0' in ASCII

    static String[] wareki_list = { "明治", "大正", "昭和", "平成" };
    static String[] wareki_char = { "M",    "T",    "S",    "H"    };
    static int[] wareki_start   = {  1868,   1912,   1926,   1989  };

    private String wareki = "";
    private int wareki_year = 0;
    private int seireki = 0;
    private boolean parsed_wareki = false;

    private boolean isNum(String str) {
        byte n = str.getBytes()[0];

        if (n < NUM_CHAR_BASE || (NUM_CHAR_BASE + 9) < n) {
            return false;
        } else {
            return true;
        }
    }

    /* seireki -> wareki */
    private void s2w(String str) {
        int s = new Integer(str);
        int idx = 0;

        int i = 0;
        for (int ws : wareki_start) {
            if (s >= ws) {
                idx = i;
                wareki = wareki_list[idx];
            }
            i++;
        }

        wareki_year = s - wareki_start[idx] + 1;
        seireki = new Integer(str);
    }

    /* wareki -> seireki */
    private void w2s(String str) {
        String wc = str.substring(0, 1).toUpperCase();
        String wv = str.substring(1);

        int ws  = 0;
        int idx = 0;
        for (String w : wareki_char) {
            if (wc.equals(w)) {
                wareki = wareki_list[idx];
                ws = wareki_start[idx];
                break;
            }
            idx++;
        }

        wareki_year = new Integer(wv);
        seireki = ws + new Integer(wv) - 1;
    }

    public void parse(String str) {
        if (isNum(str)) {
            s2w(str);
            parsed_wareki = false;
        } else {
            w2s(str);
            parsed_wareki = true;
        }
    }

    public String getWareki() {
        return wareki;
    }

    public int getWarekiYear() {
        return wareki_year;
    }

    public boolean isWareki() {
        return parsed_wareki;
    }

    public boolean isSeireki() {
        return parsed_wareki == false;
    }

    public int getSeireki() {
        return seireki;
    }
}

