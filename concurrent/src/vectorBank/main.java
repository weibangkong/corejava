package vectorBank;

public class main {

    private static final int NACCOUNTS = 100;
    private static final double INITIAL_BALANCE = 1000d;
    private static final double MAX_AMOUNT = 1000d;
    private static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () ->{
                try {
                    while (true) {
//                    bank.trantsfer();
                        Thread.sleep(DELAY);
                    }
                } catch (InterruptedException e) {

                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
