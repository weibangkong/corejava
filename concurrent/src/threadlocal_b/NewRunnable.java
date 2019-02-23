package threadlocal_b;

public class NewRunnable implements Runnable{
    private ThreadLocal<Integer> localVariable = new ThreadLocal<>();
    @Override
    public void run() {
        localVariable.set((int) (Math.random()*10));
        System.out.println(localVariable.get());
    }
}
