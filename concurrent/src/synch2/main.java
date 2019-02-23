package synch2;

public class main {
    private static final int NACCOUNTS = 100;
    private static final double INITIAL_BALANCE = 1000d;
    private static final double MAX_AMOUNT = 1000d;
    private static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int toAccount = (int) (bank.size()*Math.random());
                    try {
                        while (true) {
                            //下面的转出账户直接使用i报错
                            //原因:内部类使用但未声明的任何局部变量需要在内部类正文之前明确分配，因此有了前面的 int fromAccount = i
                            bank.transfer(fromAccount, toAccount, MAX_AMOUNT * Math.random());
                            Thread.sleep((int) (DELAY * Math.random()));
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
