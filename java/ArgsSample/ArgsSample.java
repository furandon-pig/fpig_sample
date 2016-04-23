/* ArgsSample.java */

public class ArgsSample {
    public int sum(int... val_args) {
        int sum = 0;

        for (int v : val_args) {
            sum += v;
        }

        return sum;
    }

    public static void main(String... args) {
        ArgsSample as = new ArgsSample();
        int sum = as.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sum);
    }
}

