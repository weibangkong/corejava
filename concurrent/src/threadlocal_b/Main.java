package threadlocal_b;

public class Main {
    public static void main(String[] args) {
        NewRunnable myRun = new NewRunnable();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(myRun);
            t.start();
        }
    }
}
