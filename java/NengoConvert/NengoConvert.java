/* NengoConvert.java */

import java.io.*;
import java.lang.*;

public class NengoConvert {
    public static void main(String... args) {
        Nengo nengo = new Nengo();
        StringBuilder sb = new StringBuilder();

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Ctrl-D to quit. > ");
            while (true) {
                String line = br.readLine();
                if (line == null || line.length() == 0) {
                    break;
                }

                try {
                    nengo.parse(line);

                    sb.setLength(0);
                    if (nengo.isWareki()) {
                        sb.append(nengo.getWareki());
                        sb.append(nengo.getWarekiYear());
                        sb.append("年(");
                        sb.append(nengo.getSeireki());
                        sb.append(")");
                    } else {
                        sb.append(nengo.getSeireki());
                        sb.append("年(");
                        sb.append(nengo.getWareki());
                        sb.append(nengo.getWarekiYear());
                        sb.append("年)");
                    }
                    System.out.println(sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.print("Ctrl-D to quit. > ");
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

