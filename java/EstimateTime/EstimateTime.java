/* EstimateTime.java */

public class EstimateTime {

    public void Estimate(String str) {
        int max = 1000000;
        long start, finish;

        start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            try {
                int v = Integer.parseInt(str);
                v++;
            } catch (Exception e) {
                // do nothing
            }
        }
        finish = System.currentTimeMillis();

        System.out.println("avg(millisecond)= " + new Float(finish - start).toString());
    }

    public static void main(String... args) {
        EstimateTime et = new EstimateTime();

        System.out.println("-> parse '10'");
        et.Estimate("10");

        System.out.println("-> parse null (trap exception)");
        et.Estimate(null);
    }
}

