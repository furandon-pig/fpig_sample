/* ReadLineSample.java */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadLineSample {
    public static void main(String... args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line;

        System.out.print("Ctrl-D to quit. > ");
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                System.out.print("Ctrl-D to quit. > ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
}

