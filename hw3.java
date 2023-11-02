import java.util.ArrayList;

public class vampClass {
    private static final int MIN_VALUE = 100000;
    private static final int MAX_VALUE = 999999;
    private static final int NUM_THREADS = 2;

    private static int totalVampireNumbers = 0;
    private static ArrayList<Integer> vampireNumbersFound = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            final int index = i;

            threads[i] = new Thread(() -> {
                new Worker(index).run();
            });
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        System.out.println("The TOTAL number of Vampire numbers found is: " + totalVampireNumbers);
    }

    private static boolean isVampireNumber(int number, int fang1, int fang2) {
        if (fang1 % 10 == 0 && fang2 % 10 == 0) return false;

        int product = fang1 * fang2;
        if (product != number) return false;

        char[] numberChars = Integer.toString(number).toCharArray();
        char[] productChars = (Integer.toString(fang1) + Integer.toString(fang2)).toCharArray();

        java.util.Arrays.sort(numberChars);
        java.util.Arrays.sort(productChars);

        return java.util.Arrays.equals(numberChars, productChars);
    }

    private static class Worker implements Runnable {
        private final int workerId;

        public Worker(int workerId) {
            this.workerId = workerId;
        }

        public void run() {
            for (int i = MIN_VALUE + workerId; i <= MAX_VALUE; i += NUM_THREADS) {
                for (int fang1 = 2; fang1 <= Math.sqrt(i) + 1; fang1++) {
                    if (i % fang1 == 0) {
                        int fang2 = i / fang1;
                        if (isVampireNumber(i, fang1, fang2)) {
                            synchronized (vampClass.class) {
                                totalVampireNumbers++;
                                vampireNumbersFound.add(i);
                                System.out.println("Worker " + workerId + " found: " + i);
                            }
                        }
                    }
                }
            }
        }
    }
}
