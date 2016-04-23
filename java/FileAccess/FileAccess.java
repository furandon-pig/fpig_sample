/* FileAccess.java */

import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class FileAccess {
    public static void main(String [] args) {
        File f = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;

        try {
            f = new File("output.txt");
            fos = new FileOutputStream(f);
            pw = new PrintWriter(fos);

            StringBuffer sb = new StringBuffer();
            sb.append("hello,world.");

            pw.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
