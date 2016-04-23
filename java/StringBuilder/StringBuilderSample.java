/* StringBuilderSample.java */

import java.lang.StringBuilder;

public class StringBuilderSample {
    public static void main(String... args) {
        StringBuilder sb = new StringBuilder();

        sb.append("hello,");
        sb.append("world.");
        System.out.println(sb);

        sb.setLength(0);  // clear string
        System.out.println(sb);

        sb.append("HELLO,");
        sb.append("WORLD.");
        System.out.println(sb);
    }
}

