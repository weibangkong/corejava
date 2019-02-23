package ThreadLocalTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class main {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private Lock writeLock = rwl.writeLock();
    private Lock readLock = rwl.readLock();

    public static void main(String[] args) throws InterruptedException {
//        ThreadLocal<Double> threadLocal =
        Test test = new Test();
        test.set();
        System.out.println("---------------main---------------------------");
        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println("---------------main---------------------------");

        Thread thread = new Thread(){
            public void run() {
//                test.set();
                System.out.println("---------------thread---------------------------");
                System.out.println(test.getLong());
                System.out.println(test.getString());
                System.out.println("---------------thread---------------------------");
            }
        };
        thread.start();
        thread.join();

        System.out.println("---------------main---------------------------");
        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println("---------------main---------------------------");
    }
}
